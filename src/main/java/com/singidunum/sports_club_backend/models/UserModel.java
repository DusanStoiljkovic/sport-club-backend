package com.singidunum.sports_club_backend.models;

import com.singidunum.sports_club_backend.validators.ContactNumberConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserModel {
    private String id;
    @NotBlank
    private String username;
    @Email
    private String email;
    private String password;
    private String role;
    @ContactNumberConstraint
    private String phone;
}
