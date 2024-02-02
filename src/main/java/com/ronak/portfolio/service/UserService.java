package com.ronak.portfolio.service;


import com.ronak.portfolio.DTO.JwtAuthUserDetails;
import com.ronak.portfolio.Entity.Role;
import com.ronak.portfolio.Entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {
     UserDetailsService userDetailsService();

}