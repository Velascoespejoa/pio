package com.velascoespejo.pio.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.velascoespejo.pio.jwt.JwtService;
import com.velascoespejo.pio.user.Role;
import com.velascoespejo.pio.user.User;
import com.velascoespejo.pio.user.UserRepository;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepo;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getNick(), request.getPassword()));
        UserDetails user = userRepo.findByNick(request.getNick()).orElseThrow();
        String token = jwtService.getToken(user);
        return AuthResponse.builder()
            .token(token)
            .build(); 
    }

    public AuthResponse register(RegisterRequest request){
        
        User user = User.builder()
            .nick(request.getNick())
            .passwordHashed(passwordEncoder.encode(request.getPassword()))
            .name(request.getName())
            .email(request.getEmail())
            .role(Role.USER)
            .build();

        userRepo.save(user);

        return AuthResponse.builder()
            .token(jwtService.getToken(user))
            .build();
    }

}
