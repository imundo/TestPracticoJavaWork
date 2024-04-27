/**
 * 
 */
package cl.test.java.prueba.services;

import cl.test.java.prueba.entity.Users;
import cl.test.java.prueba.entity.UsersDetail;
import cl.test.java.prueba.repository.AppTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author s2526158
 *
 */
@Service
public class UserService implements UserDetailsService {

	@Autowired
    AppTestRepository repo;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetailsService#
	 * loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {

		Users users = repo.findUser(user);
		
		if (users != null) {
			return new UsersDetail(users);
		} else {
			throw new UsernameNotFoundException("Usuario no encontrado : " + user);
		}
	}

}
