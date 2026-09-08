package com.velascoespejo.pio.auth;


import java.time.Duration;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
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

    public ResponseCookie login(LoginRequest request) {

        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getNick(),
                request.getPassword()
            )
        );

        UserDetails user = userRepo.findByNick(request.getNick())
            .orElseThrow();

        String token = jwtService.getToken(user);

         return ResponseCookie
            .from("access_token", token)
            .httpOnly(true)
            .secure(false) // true en producción con HTTPS
            .sameSite("Lax")
            .path("/")
            .maxAge(Duration.ofHours(1))
            .build();
    }

    public ResponseCookie register(RegisterRequest request) {

        User user = User.builder()
            .nick(request.getNick())
            .passwordHashed(passwordEncoder.encode(request.getPassword()))
            .name(request.getName())
            .email(request.getEmail())
            .role(Role.USER)
            .build();

        userRepo.save(user);

        String token = jwtService.getToken(user);

        return ResponseCookie
            .from("access_token", token)
            .httpOnly(true)
            .secure(false)
            .sameSite("Lax")
            .path("/")
            .maxAge(Duration.ofHours(1))
            .build();

    }

    public ResponseCookie logout() {

        return ResponseCookie
            .from("access_token", "")
            .httpOnly(true)
            .secure(false) // true en producción
            .sameSite("Lax")
            .path("/")
            .maxAge(0)
            .build();
    }

}
