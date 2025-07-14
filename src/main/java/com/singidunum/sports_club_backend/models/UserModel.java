package com.singidunum.sports_club_backend.models;

import com.singidunum.sports_club_backend.entities.Product;
import com.singidunum.sports_club_backend.validators.ContactNumberConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserModel {
    private int id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @Email
    private String email;
    private List<ProductModel> products;
}
