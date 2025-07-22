package com.singidunum.sports_club_backend.services;

import com.singidunum.sports_club_backend.entities.User;
import com.singidunum.sports_club_backend.mappers.UserMapper;
import com.singidunum.sports_club_backend.models.LoginUserModel;
import com.singidunum.sports_club_backend.models.RegisterUserModel;
import com.singidunum.sports_club_backend.models.UserModel;
import com.singidunum.sports_club_backend.repositories.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public UserModel signup(RegisterUserModel model) {
        var user = UserMapper.toEntity(model, passwordEncoder);
        var savedUser = userRepository.save(user);
        var returnUser = UserMapper.toModel(savedUser);
        return returnUser;
    }


    public User authenticate(LoginUserModel input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return userRepository.findByEmail(input.getEmail()).orElseThrow();
    }
}
