package com.singidunum.sports_club_backend.controllers;


import com.singidunum.sports_club_backend.entities.User;
import com.singidunum.sports_club_backend.models.LoginResponseModel;
import com.singidunum.sports_club_backend.models.LoginUserModel;
import com.singidunum.sports_club_backend.models.RegisterUserModel;
import com.singidunum.sports_club_backend.models.UserModel;
import com.singidunum.sports_club_backend.services.AuthenticationService;
import com.singidunum.sports_club_backend.services.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class AuthenticationController {
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    public AuthenticationController(
            JwtService jwtService,
            AuthenticationService authenticationService
    ) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseModel> authenticate(@RequestBody LoginUserModel loginUserDto) {
            User authenticationUser = authenticationService.authenticate(loginUserDto);

            String jwtToken = jwtService.generateToken(authenticationUser);

            LoginResponseModel loginResponse = new LoginResponseModel();
            loginResponse.setToken(jwtToken);
            return ResponseEntity.ok(loginResponse);
    }

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegisterUserModel registerUserDto) {
        User registeredUser = authenticationService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }


}
