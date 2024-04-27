package cl.test.java.prueba.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Response {

	@JsonProperty(value = "id")
	private String id;
	
	@JsonProperty(value = "created")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private Date created;
	
	@JsonProperty(value = "modified")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private Date modified;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	@JsonProperty(value = "last-login")
	private Date lastLogin;

	@JsonProperty(value = "isactive")
	private String isactive;
	
	@JsonProperty(value = "token", required = false)
	private String token;

}
