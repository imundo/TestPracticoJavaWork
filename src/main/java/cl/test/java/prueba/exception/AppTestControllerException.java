package cl.test.java.prueba.exception;

import cl.test.java.prueba.domain.AppTestError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppTestControllerException {

	@ExceptionHandler(AppTestException.class)
	public AppTestError handleMyException(AppTestException mex) {
		return new AppTestError(mex.getStatus(), mex.getMessage());
	}
}
