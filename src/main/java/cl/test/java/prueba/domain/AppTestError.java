package cl.test.java.prueba.domain;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class AppTestError {

	private HttpStatus errorCode;
	private String message;

	public AppTestError(HttpStatus errorCode, String message) {
		super();
		this.errorCode = errorCode;
		this.message = message;
	}

}
