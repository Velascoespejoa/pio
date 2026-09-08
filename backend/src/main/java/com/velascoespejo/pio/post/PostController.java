package com.velascoespejo.pio.post;

import java.util.List;

import com.velascoespejo.pio.like.LikeService;
import com.velascoespejo.pio.repost.RepostService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("api/posts")
public class PostController {

	private final PostService postService;
	private final LikeService likeService;
	private final RepostService repostService;


	
	@GetMapping()
	public List<PostResponseDTO> getAllPost(Authentication authentication) {
		String nick = authentication.getName();
		return postService.getAllPost(nick);
	}
	
	@GetMapping("/{id}")
	public PostResponseDTO getPostById(@PathVariable Long id, Authentication authentication) {
		String nick = authentication.getName();
		return postService.getPostById(id, nick);
	}
	
	@PostMapping()
	public ResponseEntity<PostResponseDTO> createPost(@Valid @RequestBody PostRequestDTO dto, Authentication authentication) {
		String nick = authentication.getName();
		PostResponseDTO response = postService.createPost(dto, nick);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	// @PutMapping("/{id}")
	// public PostResponseDTO updatePost(@Valid @PathVariable Long id, @RequestBody PostRequestDTO dto) {
	// 	return postService.updatePost(id,dto);
	// }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePost(@PathVariable Long id){
		postService.deletePost(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@PostMapping("/{id}/like")
	public ResponseEntity<Void> toggleLike(@PathVariable Long id, Authentication authentication){
		String nick = authentication.getName();
		likeService.toggleLike(id, nick);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();		
	}

	@PostMapping("/{id}/repost")
	public ResponseEntity<Void> toggleRepost(@PathVariable Long id, Authentication authentication){
		String nick = authentication.getName();
		repostService.toggleRepost(id, nick);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();		
	}
	
}
