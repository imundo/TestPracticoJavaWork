package cl.test.java.prueba.services;

import cl.test.java.prueba.domain.Response;
import cl.test.java.prueba.entity.Users;
import cl.test.java.prueba.exception.AppTestException;
import cl.test.java.prueba.repository.AppTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import cl.test.java.prueba.domain.Login;

@Service
public class LoginImpl implements LoginService {

	@Autowired
	AppTestRepository repo;

	@Autowired
	BCryptPasswordEncoder encoder;

	@Override
	public Object access(Login login) throws AppTestException {

		Users resp = repo.findUser(login.getUsername());

		if (resp == null || !encoder.matches(login.getPassword(), resp.getPassword())) {
			throw new AppTestException(HttpStatus.UNAUTHORIZED, "Usuario o Contrasena Invalido");
		}

		Users modified = repo.save(resp);
		
		Response data = new Response();
		data.setId(modified.getId());
		data.setCreated(modified.getCreated());
		data.setModified(modified.getModified());
		data.setLastLogin(modified.getLastLogin());
		data.setToken(modified.getToken());
		data.setIsactive("activo");
		return data;
	}

}
