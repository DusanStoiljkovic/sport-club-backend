package com.singidunum.sports_club_backend.services;

import com.singidunum.sports_club_backend.models.UserModel;
import com.singidunum.sports_club_backend.models.UserPageModel;
import com.singidunum.sports_club_backend.repositories.IUserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.singidunum.sports_club_backend.mappers.UserMapper;

import java.util.List;

@Service
public class UserService implements IUserService {
    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserModel> findAll() {
        return UserMapper.toModelList(userRepository.findAll());
    }

    @Override
    public UserPageModel findAll(Integer pageNumber, Integer pageSize) {
        return UserMapper.toPageModel(userRepository.findAll(PageRequest.of(pageNumber, pageSize)));
    }

    @Override
    public UserModel create(UserModel userModel) {
        return UserMapper.toModel(userRepository.save(UserMapper.toEntity(userModel)));
    }

    @Override
    public UserModel update(UserModel userModel) {
        var entity = UserMapper.toEntity(userModel);
        var result = userRepository.save(entity);
        return UserMapper.toModel(result);
    }
}
