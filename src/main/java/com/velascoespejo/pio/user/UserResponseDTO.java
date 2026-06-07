package com.velascoespejo.pio.user;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UserResponseDTO {

	private Long id;
	private String name;
	private String nick;
	private String email;
	private String imgPerfil;
	private LocalDateTime updateAt;
	private LocalDateTime createAt;
	
}
