package cl.test.java.prueba.controller;

import cl.test.java.prueba.domain.Login;
import cl.test.java.prueba.domain.Registro;
import cl.test.java.prueba.exception.AppTestException;
import cl.test.java.prueba.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cl.test.java.prueba.services.ProfileService;
import cl.test.java.prueba.services.RegistroService;

@RestController
public class AppTestController {

	@Autowired
	RegistroService registroService;

	@Autowired
	LoginService loginService;

	@Autowired
	ProfileService profileService;

	@PostMapping(value = "/test/registro", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> registro(@RequestBody Registro registro) throws AppTestException {
		try {
			return new ResponseEntity<Object>(registroService.crear(registro), HttpStatus.OK);
		} catch (AppTestException e) {
			return new ResponseEntity<Object>(e.getMessage(), e.getStatus());
		}
	}

	@PostMapping(value = "/test/login", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> access(@RequestBody Login login) throws AppTestException {
		try {
			return new ResponseEntity<Object>(loginService.access(login), HttpStatus.OK);
		} catch (AppTestException e) {
			throw e;
		}
	}


	@PostMapping(value = "/test/perfil/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> profile(@PathVariable String id) throws AppTestException {
		try {
			return new ResponseEntity<Object>(profileService.getProfile(id), HttpStatus.OK);
		} catch (AppTestException e) {
			throw e;
		}
	}




}
