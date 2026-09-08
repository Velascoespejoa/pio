package com.velascoespejo.pio.follow;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.velascoespejo.pio.user.UserResponseDTO;


@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("api/users")
public class FollowController {

    private final FollowService followService;

    @PostMapping("/{seguidoId}/follow")
    public ResponseEntity<Void> follow(@PathVariable Long seguidoId, Authentication authentication) {
        String nick = authentication.getName();
        followService.follow(seguidoId , nick);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{seguidoId}/follow")
    public ResponseEntity<Void> unfollow(@PathVariable Long seguidoId, Authentication authentication) {
        String nick = authentication.getName();
        followService.unfollow(seguidoId, nick);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/followers")
    public ResponseEntity<List<UserResponseDTO>> getFollowers(@PathVariable Long id){
        return ResponseEntity.ok(followService.getFollowers(id));
    }

    @GetMapping("/{id}/following")
    public ResponseEntity<List<UserResponseDTO>> getFollowing(@PathVariable Long id){
        return ResponseEntity.ok(followService.getFollowing(id));
    }
    
    @GetMapping("/{id}/followers/count")
    public ResponseEntity<Long> getFollowersCount(@PathVariable Long id){
        return ResponseEntity.ok(followService.getFollowersCount(id));
    }
    
    @GetMapping("/{id}/following/count")
    public ResponseEntity<Long> getFollowingCount(@PathVariable Long id){
        return ResponseEntity.ok(followService.getFollowingCount(id));
    }    

}
