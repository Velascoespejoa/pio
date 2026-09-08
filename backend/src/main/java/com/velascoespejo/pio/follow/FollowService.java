package com.velascoespejo.pio.follow;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.velascoespejo.pio.user.User;
import com.velascoespejo.pio.user.UserMapper;
import com.velascoespejo.pio.user.UserRepository;
import com.velascoespejo.pio.user.UserResponseDTO;
import com.velascoespejo.pio.user.UserException;

import lombok.RequiredArgsConstructor;

// FollowService
@Service
@RequiredArgsConstructor
public class FollowService {

    private final FollowRepository followRepo;
    private final UserRepository userRepo;
    private final UserMapper userMap;

    public void follow(Long seguidoId, String nick) {

        User seguidor = userRepo.findByNick(nick)
            .orElseThrow(() -> new UserException(
                "Usuario '" + nick + "' no encontrado",
                HttpStatus.NOT_FOUND
            ));

        User seguido = userRepo.findById(seguidoId)
            .orElseThrow(() -> new UserException(
                "Usuario con id '" + seguidoId + "' no encontrado",
                HttpStatus.NOT_FOUND
            ));

        if (seguidor.getId().equals(seguido.getId())) {
            throw new FollowException(
                "No puedes seguirte a ti mismo",
                HttpStatus.CONFLICT
            );
        }

        if (followRepo.existsBySeguidorAndSeguido(seguidor, seguido)) {
            throw new FollowException(
                "Ya sigues a este usuario",
                HttpStatus.CONFLICT
            );
        }

        Follow follow = new Follow();
        follow.setSeguidor(seguidor);
        follow.setSeguido(seguido);

        followRepo.save(follow);
    }


    public void unfollow(Long seguidoId, String nick) {

        User seguidor = userRepo.findByNick(nick)
            .orElseThrow(() -> new UserException(
                "Usuario '" + nick + "' no encontrado",
                HttpStatus.NOT_FOUND
            ));

        User seguido = userRepo.findById(seguidoId)
            .orElseThrow(() -> new UserException(
                "Usuario con id '" + seguidoId + "' no encontrado",
                HttpStatus.NOT_FOUND
            ));

        Follow follow = followRepo.findBySeguidorAndSeguido(seguidor, seguido)
            .orElseThrow(() -> new FollowException(
                "No sigues a este usuario",
                HttpStatus.BAD_REQUEST
            ));

        followRepo.delete(follow);
    }

    public List<UserResponseDTO> getFollowers(Long userId){
        
        List<Long> ids = followRepo.findSeguidoresIdsBySeguidoId(userId);

        List<User> users = userRepo.findAllById(ids);
        List<UserResponseDTO> dtos = new ArrayList<>();

        for (User user: users) {
            dtos.add(userMap.toDTO(user));
        }
        
        return dtos;
    }

    public List<UserResponseDTO> getFollowing(Long userId){
        
        List<Long> ids = followRepo.findSeguidosIdsBySeguidorId(userId);

        List<UserResponseDTO> dtos = new ArrayList<>();
        List<User> users = userRepo.findAllById(ids);
        
        for (User user: users) {
            dtos.add(userMap.toDTO(user));
        }
        return dtos;
    }

    public Long getFollowingCount(Long userId){
        return followRepo.countBySeguidorId(userId);
    }

    public Long getFollowersCount(Long userId){
        return followRepo.countBySeguidoId(userId);
    }
}
