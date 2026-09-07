package com.velascoespejo.pio.post;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PostRequestDTO {	

	@NotBlank(message = "El body no puede estar vacio")
	private String body;
	

}
