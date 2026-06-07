package com.velascoespejo.pio.user;

import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserMapper {

	User toEntity(UserRequestDTO dto);
	
	UserResponseDTO toDTO(User user);


}
