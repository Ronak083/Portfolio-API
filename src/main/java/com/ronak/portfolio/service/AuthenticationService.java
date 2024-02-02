package com.ronak.portfolio.service;


import com.ronak.portfolio.DTO.JwtAuthenticationResponse;
import com.ronak.portfolio.DTO.SignUpRequest;
import com.ronak.portfolio.DTO.SigninRequest;
import com.ronak.portfolio.Entity.User;

public interface AuthenticationService {
    User signup(SignUpRequest signUpRequest);
    JwtAuthenticationResponse signin(SigninRequest signinRequest);
}