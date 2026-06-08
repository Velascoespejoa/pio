package com.velascoespejo.pio.post;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.velascoespejo.pio.user.User;
import com.velascoespejo.pio.user.UserException;
import com.velascoespejo.pio.user.UserMapper;
import com.velascoespejo.pio.user.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PostService {
	
	private PostMapper postMap;
	private PostRepository postRepo;
	private UserMapper userMap;
	private UserRepository userRepo;
	
	public List<PostResponseDTO> getAllPost() {
		
		List<Post> posts = postRepo.findAll();
		List<PostResponseDTO> dtos = new ArrayList<>();
		
		for (Post post : posts) {
			dtos.add(postMap.toDTO(post));
		}
		
		return dtos;
	}

	public PostResponseDTO getPostById(Long id) {
		
		Post post = postRepo.findById(id).orElseThrow(
				()-> new PostException("id no encontrado", HttpStatus.NOT_FOUND));
		
		
		return postMap.toDTO(post);
	}

	public PostResponseDTO createPost(PostRequestDTO dto) {
		
		User user = userRepo.findById(dto.getUserId()).orElseThrow(
				()-> new UserException("id de usuario no existe",HttpStatus.NOT_FOUND));

		Post post = postMap.toEntity(dto);

		post.setUser(user);
		
		Post postGuardado = postRepo.save(post);
		
		return postMap.toDTO(postGuardado);
	}

	public PostResponseDTO updatePost(Long id, PostRequestDTO dto) {
		
		User user = userRepo.findById(dto.getUserId()).orElseThrow(
				()-> new UserException("id de usuario no existe",HttpStatus.NOT_FOUND));
		
		Post post = postRepo.findById(id).orElseThrow(
				()-> new PostException("id no encontrado", HttpStatus.NOT_FOUND));
		
		post.setBody(dto.getBody());
		post.setUser(user); // ¿hace falta?
		
		Post postActualizado = postRepo.save(post);
		
		return postMap.toDTO(postActualizado);
	}

	public void deletePost(Long id) {
		Post post = postRepo.findById(id).orElseThrow(
				()-> new PostException("id no encontrado", HttpStatus.NOT_FOUND));
		postRepo.delete(post);
		
	}
	
	
	

}
