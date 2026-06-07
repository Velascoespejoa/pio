package com.velascoespejo.pio.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRequestDTO {

	@NotBlank(message = "name es obligatorio")
	private String name;
	
	@NotBlank(message = "nick es obligatorio")
	private String nick;
	
	@Email(message = "formato de email incorrecto")
	@NotBlank(message = "email es obligatorio")
	private String email;
	
	@NotBlank(message = "password es obligatorio")
	private String password;
}
