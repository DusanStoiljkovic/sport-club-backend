package com.singidunum.sports_club_backend.models;

import lombok.Data;

@Data
public class LoginResponseModel {
    private String token;
    private long expiresIn;
}
