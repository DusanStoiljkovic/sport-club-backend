package com.singidunum.sports_club_backend.services;

import com.singidunum.sports_club_backend.entities.User;
import com.singidunum.sports_club_backend.exceptions.user.UserAlreadyExistException;
import com.singidunum.sports_club_backend.mappers.UserMapper;
import com.singidunum.sports_club_backend.models.LoginResponseModel;
import com.singidunum.sports_club_backend.models.LoginUserModel;
import com.singidunum.sports_club_backend.models.RegisterUserModel;
import com.singidunum.sports_club_backend.models.UserModel;
import com.singidunum.sports_club_backend.repositories.IUserRepository;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public UserModel signup(RegisterUserModel model) {
        var user = UserMapper.toEntity(model, passwordEncoder);
        if(userRepository.findByEmail(model.getEmail()).isPresent()) {
            throw new UserAlreadyExistException("User already exist");
        }
        var savedUser = userRepository.save(user);
        return UserMapper.toModel(savedUser);

    }


    public LoginResponseModel authenticate(LoginUserModel input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        var authenticatedUser = userRepository.findByEmail(input.getEmail()).orElseThrow(
                () -> new UsernameNotFoundException("User with email " + input.getEmail() + " is not found.")
        );

        String jwtToken = jwtService.generateToken(authenticatedUser);
        LoginResponseModel loginResponse = new LoginResponseModel();
        loginResponse.setToken(jwtToken);

        return loginResponse;
    }
}
