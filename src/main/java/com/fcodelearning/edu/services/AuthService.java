package com.fcodelearning.edu.services;

import com.fcodelearning.edu.dto.*;
import com.fcodelearning.edu.exception.ResourceNotFoundException;
import com.fcodelearning.edu.model.Role;
import com.fcodelearning.edu.model.User;
import com.fcodelearning.edu.repository.UserRepository;
import com.fcodelearning.edu.security.JwtService;
import com.fcodelearning.edu.util.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final ObjectMapper objectMapper;
    private final UserDetailsService userDetailsService;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(request.getRoles())
                .datejoined(LocalDate.now())
                .lastupdated(LocalDateTime.now())
                .build();

        var savedUser = userRepository.save(user);

        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        //saveUserToken(savedUser, jwtToken);

        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        User user = userRepository.findByUsername(request.getUsername()).orElseThrow();
        UserDTO userDto = objectMapper.userToUserDTO(user);
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);

        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .authUser(
                        AuthUser.builder()
                                .user(userDto)
                                .authorities(getUserAuthoritiesByUsername(request.getUsername()))
                                .build()
                )
                .build();
    }

    public AuthenticationResponse refreshToken(String token) {

        User user = userRepository.findByUsername(jwtService.extractUsername(token)).orElseThrow();
        UserDTO userdto = objectMapper.userToUserDTO(user);

        if (
                jwtService.isTokenValid(token, user)
        ) {
            String accessToken = jwtService.generateToken(user);

            return AuthenticationResponse.builder()
                    .accessToken(accessToken)
                    .authUser(
                            AuthUser.builder()
                                    .user(userdto)
                                    .authorities(getUserAuthoritiesByUsername(user.getEmail()))
                                    .build()
                    )
                    .build();
        }else throw new ResourceNotFoundException("Invalid Refresh Token");//need to be an Authentication Exception
    }

    private List<String> getUserAuthoritiesByUsername(String username){
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        return userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).toList();
    }
}
