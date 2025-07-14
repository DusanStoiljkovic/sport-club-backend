package com.singidunum.sports_club_backend.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProductWithCategoriesModel {
    private int id;
    private String name;
    private List<CategoryModel> categories;
}
