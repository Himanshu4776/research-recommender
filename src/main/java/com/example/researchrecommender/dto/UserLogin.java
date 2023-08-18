package com.example.researchrecommender.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserLogin {
    public String email;
    public String password;
}