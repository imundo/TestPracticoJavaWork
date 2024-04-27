package cl.test.java.prueba.services;

import cl.test.java.prueba.domain.Login;
import cl.test.java.prueba.exception.AppTestException;

/**
 * 
 * @author s2526158
 *
 */
public interface LoginService {

	public Object access(Login login) throws AppTestException;

}
