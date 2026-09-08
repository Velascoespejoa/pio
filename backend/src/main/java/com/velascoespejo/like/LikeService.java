package com.velascoespejo.pio.like;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import com.velascoespejo.pio.user.User;
import com.velascoespejo.pio.user.UserRepository;
import com.velascoespejo.pio.post.Post;
import com.velascoespejo.pio.post.PostRepository;

import java.util.Optional;
import org.springframework.http.HttpStatus;
import com.velascoespejo.pio.user.UserException;
import com.velascoespejo.pio.post.PostException;

@Service
@AllArgsConstructor
public class LikeService {

    private final PostRepository postRepo;
    private final UserRepository userRepo;
    private final LikeRepository likeRepo;

    public void toggleLike(Long post_id, String nick) {

        User user = userRepo.findByNick(nick)
            .orElseThrow(() -> new UserException(
                "Usuario '" + nick + "' no encontrado",
                HttpStatus.NOT_FOUND
            ));

        Post post = postRepo.findById(post_id)
            .orElseThrow(() -> new PostException(
                "Post con id '" + post_id + "' no encontrado",
                HttpStatus.NOT_FOUND
            ));

        Optional<Like> existingLike = likeRepo.findByUserAndPost(user, post);

        if (existingLike.isPresent()) {
            likeRepo.delete(existingLike.get());
        } else {
            Like like = new Like();
            like.setUser(user);
            like.setPost(post);
            likeRepo.save(like);
        }        
    }
}