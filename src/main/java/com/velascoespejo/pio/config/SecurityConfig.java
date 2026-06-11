package com.velascoespejo.pio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;


import lombok.RequiredArgsConstructor;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http){
        return http
        .csrf(csrf ->   
            csrf.disable()
        )
        .authorizeHttpRequests(authRequest ->
            authRequest
                .requestMatchers("/auth/**").permitAll()
                .anyRequest().authenticated()
        )
        .sessionManagement(sessionManager->
            sessionManager
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authenticationProvider(authProvider)
        .addFilterBefore(JwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)    
        .build();
    }

    //esto habra que trabajarlo en un futuro
    // @Bean
    // public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    //     http
    //         .csrf(csrf -> csrf.disable())
    //         .authorizeHttpRequests(auth -> auth
    //             .requestMatchers("/api/**").permitAll()
    //             .requestMatchers("/h2-console/**").permitAll()
    //             .anyRequest().authenticated()
    //         )
    //         .formLogin(form -> form.permitAll())
    //         .headers(headers -> headers
    //             .frameOptions(frame -> frame.sameOrigin())
    //         );

    //     return http.build();
    // }
    
}