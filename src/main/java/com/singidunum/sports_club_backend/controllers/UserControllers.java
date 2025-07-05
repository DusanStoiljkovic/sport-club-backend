package com.singidunum.sports_club_backend.controllers;

import com.singidunum.sports_club_backend.models.UserModel;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserControllers {
    @CrossOrigin("*")
    @GetMapping
    public UserModel getUser() {
        return new UserModel();
    }

    @CrossOrigin("*")
    @GetMapping("get-first-name")
    public String getFirstName() {
        return "Dusan";
    }

    @PostMapping("create-user-body")
    public ResponseEntity<?> createUserBody(@RequestBody @Valid UserModel user, BindingResult result) {
        if(result.hasErrors()) {
            return new ResponseEntity<>("Neuspesno registrovan,", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<UserModel>(user, HttpStatus.CREATED);
    }
}
