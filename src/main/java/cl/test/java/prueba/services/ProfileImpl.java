package cl.test.java.prueba.services;

import cl.test.java.prueba.domain.Response;
import cl.test.java.prueba.entity.Users;
import cl.test.java.prueba.exception.AppTestException;
import cl.test.java.prueba.repository.AppTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ProfileImpl implements ProfileService {

	@Autowired
	AppTestRepository repo;

	@Override
	public Object getProfile(String id) throws AppTestException {
		Users users = repo.getById(id);
		if (users == null) {
			throw new AppTestException(HttpStatus.NO_CONTENT, "No existe usuario");
		}

		Response data = new Response();
		data.setId(users.getId());
		data.setCreated(users.getCreated());
		data.setModified(users.getModified());
		data.setLastLogin(users.getLastLogin());
		data.setToken(users.getToken());
		data.setIsactive("activo");
		return data;
	}

}
