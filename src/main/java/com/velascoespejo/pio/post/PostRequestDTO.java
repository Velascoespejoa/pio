package com.velascoespejo.pio.post;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PostRequestDTO {
	

	@NotBlank(message = "El body no puede estar vacio")
	private String body;
	
	@NotNull(message = "el usuario es obligatorio")
	private Long userId;

}
