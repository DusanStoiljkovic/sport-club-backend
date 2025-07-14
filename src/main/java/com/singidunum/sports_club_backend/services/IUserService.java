package com.singidunum.sports_club_backend.services;

import com.singidunum.sports_club_backend.models.UserModel;
import com.singidunum.sports_club_backend.models.UserPageModel;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IUserService {
    List<UserModel> findAll();
    UserPageModel findAll(Integer pageNumber, Integer pageSize);
    UserModel create(UserModel userModel);
}
