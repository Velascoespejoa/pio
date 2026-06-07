package com.velascoespejo.pio.post;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	private PostService postService;
	
	@GetMapping()
	public List<PostResponseDTO> getAllPost() {
		return postService.getAllPost();
	}
	
	@GetMapping("/{id}")
	public PostResponseDTO getPostById(@PathVariable Long id) {
		return postService.getPostById(id);
	}
	
	@PostMapping()
	public ResponseEntity<PostResponseDTO> createPost(@Valid @RequestBody PostRequestDTO dto) {
		PostResponseDTO response = postService.createPost(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@PutMapping("/{id}")
	public PostResponseDTO updatePost(@Valid @PathVariable Long id, @RequestBody PostRequestDTO dto) {
		return postService.updatePost(id,dto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePost(@PathVariable Long id){
		postService.deletePost(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	
}
