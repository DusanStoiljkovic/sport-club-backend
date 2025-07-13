package com.singidunum.sports_club_backend.controllers;
import com.singidunum.sports_club_backend.mappers.UserMapper;
import com.singidunum.sports_club_backend.models.UserModel;
import com.singidunum.sports_club_backend.models.UserPageModel;
import com.singidunum.sports_club_backend.repositories.IUserRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserControllers {
    private final IUserRepository userRepository;
    public UserControllers(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("get-user-list")
    public List<UserModel> getUserList() {
        return UserMapper.toModelList(userRepository.findAll());
    }

    @CrossOrigin("*")
    @GetMapping("get-user-page-list")
    public UserPageModel getUserPageList(Integer pageNumber, Integer pageSize) {
        return UserMapper.toPageModel(userRepository.findAll(PageRequest.of(pageNumber, pageSize)));
    }

    @CrossOrigin("*")
    @PostMapping("create-user-body")
    public ResponseEntity<?> createUserBody(@RequestBody @Valid UserModel userModel, BindingResult result) {
        if(result.hasErrors()) {
            return new ResponseEntity<>("Neuspesno registrovan!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        var entity = UserMapper.toEntity(userModel);

        userRepository.save(entity);

        return new ResponseEntity<UserModel>(userModel, HttpStatus.CREATED);
    }
}
