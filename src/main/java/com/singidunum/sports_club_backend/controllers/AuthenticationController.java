package com.singidunum.sports_club_backend.controllers;


import com.singidunum.sports_club_backend.entities.User;
import com.singidunum.sports_club_backend.models.LoginResponseModel;
import com.singidunum.sports_club_backend.models.LoginUserModel;
import com.singidunum.sports_club_backend.models.RegisterUserModel;
import com.singidunum.sports_club_backend.models.UserModel;
import com.singidunum.sports_club_backend.services.AuthenticationService;
import com.singidunum.sports_club_backend.services.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody RegisterUserModel model) {
        return ResponseEntity.ok(authenticationService.signup(model));
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody LoginUserModel model) {
        return ResponseEntity.ok(authenticationService.authenticate(model));
    }
}