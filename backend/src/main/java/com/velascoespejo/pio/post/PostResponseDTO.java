package com.velascoespejo.pio.post;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PostResponseDTO {
	private Long id;
	private String body;
	private LocalDateTime createAt;
	private LocalDateTime updateAt;
	private Long userId;
	private String userName;
	private String userNick;
	private String userImgPerfil;

    private Long likeCount;
    private Long repostCount;
	private Long views;

	private boolean likedByMe;
	private boolean repostedByMe;
	private boolean viewed;
}
