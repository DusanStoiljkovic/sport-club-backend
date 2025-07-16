package com.singidunum.sports_club_backend.controllers;
import com.singidunum.sports_club_backend.mappers.UserMapper;
import com.singidunum.sports_club_backend.models.UserModel;
import com.singidunum.sports_club_backend.models.UserPageModel;
import com.singidunum.sports_club_backend.repositories.IUserRepository;
import com.singidunum.sports_club_backend.services.IUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserControllers {
    private final IUserService userService;

    @GetMapping("get-list")
    public List<UserModel> getUserList() {
        return userService.findAll();
    }

    @GetMapping("get-page-list")
    public UserPageModel getUserPageList(Integer pageNumber, Integer pageSize) {
        return userService.findAll(pageNumber, pageSize);
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody @Valid UserModel userModel, BindingResult result) {
        if(result.hasErrors()) {
            return new ResponseEntity<>("Neuspesno registrovan!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(userService.create(userModel), HttpStatus.CREATED);
    }

    @PostMapping("update")
    public ResponseEntity<?> update(@RequestBody @Valid UserModel userModel, BindingResult result) {
        if(result.hasErrors()) {
            return new ResponseEntity<>("Neuspesno registrovan!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(userService.update(userModel), HttpStatus.CREATED);
    }
}
