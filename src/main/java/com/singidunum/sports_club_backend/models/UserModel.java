package com.singidunum.sports_club_backend.models;

import com.singidunum.sports_club_backend.validators.ContactNumberConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserModel {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;
    private String phone;
}
