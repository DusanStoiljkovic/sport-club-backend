package com.singidunum.sports_club_backend.mappers;

import com.singidunum.sports_club_backend.entities.Product;
import com.singidunum.sports_club_backend.entities.User;
import com.singidunum.sports_club_backend.models.ProductModel;
import com.singidunum.sports_club_backend.models.UserModel;
import com.singidunum.sports_club_backend.models.UserPageModel;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class ProductMapper {
    public static ProductModel toModel(Product entity) {
        return ProductModel.builder()
                .name(entity.getName()).build();
    }

    public static List<ProductModel> toModelList(List<Product> entities) {
        List<ProductModel> models = new ArrayList<>();
        for (Product entity : entities) {
            models.add(toModel(entity));
        }
        return models;
    }
}
