package com.ronak.portfolio.DTO;

import com.ronak.portfolio.Entity.Role;
import lombok.Data;

@Data
public class JwtAuthUserDetails {
    private Role role;
    private String name;
}