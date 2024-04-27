package cl.test.java.prueba.domain;

import java.util.List;

import lombok.Data;

@Data
public class Registro {

	private String name;

	private String email;

	private String password;

	private List<Phone> phones;

}
