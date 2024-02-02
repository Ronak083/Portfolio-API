package com.ronak.portfolio.Controller;

import com.ronak.portfolio.DTO.JwtAuthUserDetails;
import com.ronak.portfolio.DTO.JwtAuthenticationResponse;
import com.ronak.portfolio.DTO.SignUpRequest;
import com.ronak.portfolio.DTO.SigninRequest;
import com.ronak.portfolio.Entity.User;
import com.ronak.portfolio.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;


    @PostMapping("/signup")
    public ResponseEntity<User> signup (@RequestBody SignUpRequest signUpRequest){
        return ResponseEntity.ok(authenticationService.signup(signUpRequest));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SigninRequest signinRequest){
        return ResponseEntity.ok(authenticationService.signin(signinRequest));
    }

    @GetMapping("/userDetail/")
    public ResponseEntity<JwtAuthUserDetails> getUserInfo(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User jwtUser = (User) auth.getPrincipal();

        JwtAuthUserDetails currUser = new JwtAuthUserDetails();
        currUser.setName(jwtUser.getName());
        currUser.setRole(jwtUser.getRole());
        return ResponseEntity.ok(currUser);
    }

}