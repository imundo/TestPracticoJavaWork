package cl.test.java.prueba.services;

import cl.test.java.prueba.domain.Registro;
import cl.test.java.prueba.exception.AppTestException;

/**
 * 
 * @author s2526158
 *
 */
public interface RegistroService {

	public Object crear(Registro registro) throws AppTestException;

}
