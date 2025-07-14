package com.singidunum.sports_club_backend.mappers;

import com.singidunum.sports_club_backend.entities.Category;
import com.singidunum.sports_club_backend.models.CategoryWithProductsModel;

import java.util.ArrayList;
import java.util.List;

public class CategoryWithProductsMapper {
    public static CategoryWithProductsModel toModel(Category entity) {
        return CategoryWithProductsModel.builder()
                .id(entity.getId())
                .name(entity.getName())
                .products(ProductMapper.toModelList(entity.getProducts()))
                .build();
    }

    public static List<CategoryWithProductsModel> toModelList(List<Category> entities) {
        var list = new ArrayList<CategoryWithProductsModel>();
        for (Category entity : entities) {
            list.add(toModel(entity));
        }
        return list;
    }
}
