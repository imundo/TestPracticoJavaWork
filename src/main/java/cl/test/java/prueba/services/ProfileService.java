package cl.test.java.prueba.services;

import cl.test.java.prueba.exception.AppTestException;

/**
 * 
 * @author s2526158
 *
 */
public interface ProfileService {

	public Object getProfile(String id) throws AppTestException;
}
