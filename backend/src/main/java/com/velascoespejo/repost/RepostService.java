package com.velascoespejo.pio.repost;

import com.velascoespejo.pio.user.User;
import com.velascoespejo.pio.user.UserRepository;
import com.velascoespejo.pio.post.Post;
import com.velascoespejo.pio.post.PostRepository;
import com.velascoespejo.pio.user.UserException;
import com.velascoespejo.pio.post.PostException;

import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class RepostService {
    
    private final PostRepository postRepo;
    private final UserRepository userRepo;
    private final RepostRepository repostRepo;

    public void toggleRepost(Long post_id, String nick){
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

        Optional<Repost> existingRepost = repostRepo.findByUserAndPost(user, post);

        if(existingRepost.isPresent()){
            repostRepo.delete(existingRepost.get());
        }else{
            Repost repost = new Repost();
            repost.setUser(user);
            repost.setPost(post);
            repostRepo.save(repost);
        }

    }
}
