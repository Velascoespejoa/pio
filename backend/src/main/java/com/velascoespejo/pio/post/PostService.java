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
import com.velascoespejo.pio.like.LikeRepository;
import com.velascoespejo.pio.repost.RepostRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PostService {
	
	private PostMapper postMap;
	private PostRepository postRepo;
	private UserMapper userMap;
	private UserRepository userRepo;
	private LikeRepository likeRepo;
	private RepostRepository repostRepo;
	
	public List<PostResponseDTO> getAllPost(String nick) {

		User user = userRepo.findByNick(nick).orElseThrow(
				() -> new UserException("Usuario '" + nick + "' no encontrado", HttpStatus.NOT_FOUND));
		
		
		List<Post> posts = postRepo.findAll();
		List<PostResponseDTO> dtos = new ArrayList<>();
		
		for (Post post : posts) {

			long likeCount = likeRepo.countByPostId(post.getId());
			long repostCount = repostRepo.countByPostId(post.getId());
			boolean likedByMe = likeRepo.existsByUserAndPost(user, post);
			boolean repostedByMe = repostRepo.existsByUserAndPost(user, post);

			PostResponseDTO dto = postMap.toDTO(post);
			dto.setLikeCount(likeCount);
			dto.setRepostCount(repostCount);
			dto.setLikedByMe(likedByMe);
			dto.setRepostedByMe(repostedByMe);

			dtos.add(dto);
		}
		
		return dtos;
	}

	public PostResponseDTO getPostById(Long id, String nick) {
		
		Post post = postRepo.findById(id).orElseThrow(
				()-> new PostException("id no encontrado", HttpStatus.NOT_FOUND));
		User user = userRepo.findByNick(nick).orElseThrow(
				() -> new UserException("Usuario '" + nick + "' no encontrado", HttpStatus.NOT_FOUND));
		
		long likeCount = likeRepo.countByPostId(post.getId());
		long repostCount = repostRepo.countByPostId(post.getId());

		boolean likedByMe = likeRepo.existsByUserAndPost(user, post);
		boolean repostedByMe = repostRepo.existsByUserAndPost(user, post);

		PostResponseDTO dto = postMap.toDTO(post);	
		dto.setLikeCount(likeCount);
		dto.setRepostCount(repostCount);
		dto.setLikedByMe(likedByMe);
		dto.setRepostedByMe(repostedByMe);
		return dto;
	}

	public PostResponseDTO createPost(PostRequestDTO requestDTO, String nick) {
		
		User user = userRepo.findByNick(nick).orElseThrow(
				()-> new UserException("No existe ese usuario", HttpStatus.NOT_FOUND));

		Post post = postMap.toEntity(requestDTO);

		post.setUser(user);
		
		Post postGuardado = postRepo.save(post);

		PostResponseDTO dto = postMap.toDTO(post);
		dto.setLikeCount(0L);
		dto.setRepostCount(0L);
		dto.setLikedByMe(false);
		dto.setRepostedByMe(false);
		
		return dto;
	}

	// public PostResponseDTO updatePost(Long id, PostRequestDTO dto) {
		
	// 	User user = userRepo.findById(dto.getUserId()).orElseThrow(
	// 			()-> new UserException("id de usuario no existe",HttpStatus.NOT_FOUND));
		
	// 	Post post = postRepo.findById(id).orElseThrow(
	// 			()-> new PostException("id no encontrado", HttpStatus.NOT_FOUND));
		
	// 	post.setBody(dto.getBody());
	// 	post.setUser(user); // ¿hace falta?
		
	// 	Post postActualizado = postRepo.save(post);
		
	// 	return postMap.toDTO(postActualizado);
	// }

	public void deletePost(Long id) {
		Post post = postRepo.findById(id).orElseThrow(
				()-> new PostException("id no encontrado", HttpStatus.NOT_FOUND));
		postRepo.delete(post);
		
	}

	public List<PostResponseDTO>timeline(String nick){
		
		User user = userRepo.findByNick(nick)
            .orElseThrow(() -> new UserException(
                "Usuario '" + nick + "' no encontrado",
                HttpStatus.NOT_FOUND
            ));

		List<Post> posts = postRepo.findTimeline(user.getId());
		List<PostResponseDTO> dtos = new ArrayList<>();
		
		for (Post post : posts) {

			long likeCount = likeRepo.countByPostId(post.getId());
			long repostCount = repostRepo.countByPostId(post.getId());
			boolean likedByMe = likeRepo.existsByUserAndPost(user, post);
			boolean repostedByMe = repostRepo.existsByUserAndPost(user, post);

			PostResponseDTO dto = postMap.toDTO(post);
			dto.setLikeCount(likeCount);
			dto.setRepostCount(repostCount);
			dto.setLikedByMe(likedByMe);
			dto.setRepostedByMe(repostedByMe);

			dtos.add(dto);
		}

		return dtos;
	}
	
	
	

}
