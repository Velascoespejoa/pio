package com.velascoespejo.pio.auth;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("login")
    public ResponseEntity<Void> login(@RequestBody LoginRequest request) {

        ResponseCookie cookie = authService.login(request);

        return ResponseEntity
            .ok()
            .header(HttpHeaders.SET_COOKIE, cookie.toString())
            .build();
    }
    
    @PostMapping("register")
    public ResponseEntity<Void> register(@RequestBody RegisterRequest request) {

        ResponseCookie cookie = authService.register(request);

        return ResponseEntity
            .ok()
            .header(HttpHeaders.SET_COOKIE, cookie.toString())
            .build();
    }
    
    @PostMapping("logout")
    public ResponseEntity<Void> logout(){

        ResponseCookie cookie = authService.logout();
        return ResponseEntity
            .ok()
            .header(HttpHeaders.SET_COOKIE, cookie.toString())
            .build();
    }
}
