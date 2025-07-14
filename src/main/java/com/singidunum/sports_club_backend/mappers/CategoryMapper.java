package com.singidunum.sports_club_backend.mappers;

import com.singidunum.sports_club_backend.entities.Category;
import com.singidunum.sports_club_backend.models.CategoryModel;

import java.util.ArrayList;
import java.util.List;

public class CategoryMapper {
    public static CategoryModel toModel(Category entity) {
        return CategoryModel.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    public static List<CategoryModel> toModelList(List<Category> entities) {
        var result = new ArrayList<CategoryModel>();
        for (Category entity : entities) {
            result.add(CategoryMapper.toModel(entity));
        }
        return result;
    }
}
