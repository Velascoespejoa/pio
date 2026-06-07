package com.velascoespejo.pio.post;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.velascoespejo.pio.user.User;
import com.velascoespejo.pio.user.UserRequestDTO;
import com.velascoespejo.pio.user.UserResponseDTO;


@Mapper(componentModel = "spring")
public interface PostMapper {

	
	Post toEntity(PostRequestDTO dto);
	
	@Mapping(source = "user.id", target = "userId")
	@Mapping(source = "user.name", target = "userName")
	@Mapping(source = "user.nick", target = "userNick")
	PostResponseDTO toDTO(Post post);


}
