package com.velascoespejo.pio.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

	@NotBlank(message = "name es obligatorio")
	private String name;
	
	@NotBlank(message = "nick es obligatorio")	
	private String nick;
	
	@Email(message = "formato de email incorrecto")
	@NotBlank(message = "email es obligatorio")
	private String email;
	
	@NotBlank(message = "password es obligatorio")
	@Size(min = 8, max= 20, message = "password debe contener entre 8-20 carácteres")
	private String password;

}
