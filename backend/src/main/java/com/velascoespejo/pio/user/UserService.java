package com.velascoespejo.pio.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class UserService {

	private final UserRepository userRepo;
	private final UserMapper userMap;
	private final PasswordEncoder passEncoder;
	
	
	public List<UserResponseDTO> getAllUser(){
		
		List<User> users = userRepo.findAll();
		List<UserResponseDTO> dtos = new ArrayList<>();
		
		for (User user : users) {
			dtos.add(userMap.toDTO(user));
		}
		
		return dtos;
	}


	public UserResponseDTO getUserById(Long id) {
		
		User user = userRepo.findById(id).orElseThrow(
					()-> new UserException("id: '"+id+"' de usuario no encontrado", HttpStatus.NOT_FOUND)
				);
		
		return userMap.toDTO(user);
	}


	public UserResponseDTO createUser(UserRequestDTO dto) {

	    if (userRepo.findByEmail(dto.getEmail()).isPresent()) {
	    	throw new UserException("El email '"+ dto.getEmail() +"' ya está en uso", HttpStatus.CONFLICT);
	    }
	    if (userRepo.findByNick(dto.getNick()).isPresent()) {
	    	throw new UserException("El nick '"+ dto.getNick() +"' ya está en uso", HttpStatus.CONFLICT);
	    }
		
	    User user = userMap.toEntity(dto);
	    user.setPasswordHashed(passEncoder.encode(dto.getPassword()));
	    
	    User userGuardado = userRepo.save(user);    
	    		
		return userMap.toDTO(userGuardado);
	}


	public UserResponseDTO updateUser(Long id, UserRequestDTO dto) {
		
		User user = userRepo.findById(id).orElseThrow(
				()-> new UserException("id: '"+id+"' de usuario no encontrado", HttpStatus.NOT_FOUND));
		
	    if (userRepo.findByEmail(dto.getEmail()).isPresent() && !user.getEmail().equals(dto.getEmail())) {
	    	throw new UserException("El nick '"+ dto.getNick() +"' ya está en uso", HttpStatus.CONFLICT);
	    }
	    if (userRepo.findByNick(dto.getNick()).isPresent() && !user.getNick().equals(dto.getNick())) {
	    	throw new UserException("El nick '"+ dto.getNick() +"' ya está en uso", HttpStatus.CONFLICT);
	    }
		
		user.setEmail(dto.getEmail());
		user.setName(dto.getName());
		user.setNick(dto.getNick());
		user.setPasswordHashed(passEncoder.encode(dto.getPassword()));
		
		User userGuardado = userRepo.save(user);
		
		return userMap.toDTO(userGuardado);
	}
	
	public void deleteUser(Long id) {
		
		User user = userRepo.findById(id).orElseThrow(
				()-> new UserException("id: '"+id+"' de usuario no encontrado", HttpStatus.NOT_FOUND));
		
		userRepo.delete(user);
	}
	
	

	
	
}
