package com.ronak.portfolio.DTO;

import lombok.Data;

@Data
public class SigninRequest {
    private String email;
    private String password;
}