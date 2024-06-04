package com.example.work_management.response;

import lombok.Data;

@Data
public class TokenResponse{
    private String acessToken;
    private String refreshToken;
}
