package com.velascoespejo.pio.post;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PostResponseDTO {
	
	private String body;
	private LocalDateTime createAt;
	private LocalDateTime updateAt;
	private Long userId;
	private String userName;
	private String userNick;
	 
}
