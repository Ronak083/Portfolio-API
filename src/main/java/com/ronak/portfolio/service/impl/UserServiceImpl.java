package com.ronak.portfolio.service.impl;

import com.ronak.portfolio.Configuration.ResourceNotExisted;
import com.ronak.portfolio.DTO.JwtAuthUserDetails;
import com.ronak.portfolio.Entity.Role;
import com.ronak.portfolio.Entity.User;
import com.ronak.portfolio.repository.UserRepository;
import com.ronak.portfolio.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public UserDetailsService userDetailsService(){
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
                return userRepository.findByEmail(username);
            }
        };
    }
        
}