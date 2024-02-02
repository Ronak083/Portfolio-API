package com.ronak.portfolio.service.impl;


import com.ronak.portfolio.DTO.JwtAuthenticationResponse;
import com.ronak.portfolio.DTO.SignUpRequest;
import com.ronak.portfolio.DTO.SigninRequest;
import com.ronak.portfolio.Entity.Role;
import com.ronak.portfolio.Entity.User;
import com.ronak.portfolio.repository.UserRepository;
import com.ronak.portfolio.service.AuthenticationService;
import com.ronak.portfolio.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public User signup(SignUpRequest signUpRequest){
        User user = new User();
        user.setEmail(signUpRequest.getEmail());
        user.setName(signUpRequest.getName());
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

        return userRepository.save(user);

    }

    public JwtAuthenticationResponse signin(SigninRequest signinRequest) throws IllegalArgumentException{
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signinRequest.getEmail(), signinRequest.getPassword()));
        var user = userRepository.findByEmail(signinRequest.getEmail());
        var jwt = jwtService.generateToken(user);

        JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();
        jwtAuthenticationResponse.setToken(jwt);
        return jwtAuthenticationResponse;
    }
}