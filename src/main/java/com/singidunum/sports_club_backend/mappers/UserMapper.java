package com.singidunum.sports_club_backend.mappers;

import com.singidunum.sports_club_backend.entities.User;
import com.singidunum.sports_club_backend.models.RegisterUserModel;
import com.singidunum.sports_club_backend.models.UserModel;
import com.singidunum.sports_club_backend.models.UserPageModel;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {
    public static UserModel toModel(User entity) {
        return UserModel.builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .contactNumber(entity.getContactNumber())
                //.products(ProductMapper.toModelList(entity.getProducts()))
                .build();
    }

    public static List<UserModel> toModelList(List<User> entities) {
        var list = new ArrayList<UserModel>();
        for (var entity : entities) {
            list.add(toModel(entity));
        }
        return list;
    }

    public static UserPageModel toPageModel(Page<User> pageEntity) {
        return UserPageModel.builder()
                .users(UserMapper.toModelList(pageEntity.getContent()))
                .totalElements(pageEntity.getNumberOfElements())
                .totalPages(pageEntity.getTotalElements()   )
                .build();
    }

    public static User toEntity(UserModel model) {
        User user = new User();
        user.setId(model.getId());
        user.setFirstName(model.getFirstName());
        user.setLastName(model.getLastName());
        user.setEmail(model.getEmail());
        user.setContactNumber(model.getContactNumber());
        user.setProducts(
                model.getProducts() != null
                ? ProductMapper.toEntityList(model.getProducts())
                : new ArrayList<>()
        );
        return user;
    }

    public static User toEntity(RegisterUserModel model, PasswordEncoder passwordEncoder) {
        User user = new User();
        user.setEmail(model.getEmail());
        user.setPassword(passwordEncoder.encode(model.getPassword()));
        return user;
    }
}
