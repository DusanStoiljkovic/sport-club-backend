package com.singidunum.sports_club_backend.mappers;

import com.singidunum.sports_club_backend.entities.Product;
import com.singidunum.sports_club_backend.models.ProductModel;
import com.singidunum.sports_club_backend.models.ProductWithCategoriesModel;

import java.util.ArrayList;
import java.util.List;

public class ProductWithCategoriesMapper {
    public static ProductWithCategoriesModel toModel(Product entity) {
        return ProductWithCategoriesModel.builder()
                .name(entity.getName())
                .categories(CategoryMapper.toModelList(entity.getCategories()))
                .build();
    }

    public static List<ProductWithCategoriesModel> toModelList(List<Product> entities) {
        List<ProductWithCategoriesModel> models = new ArrayList<>();
        for (Product entity : entities) {
            models.add(toModel(entity));
        }
        return models;
    }

    public static Product toEntity(ProductWithCategoriesModel model) {
        Product product = new Product();
        product.setName(model.getName());
        return product;
    }

    public static List<Product> toEntityList(List<ProductWithCategoriesModel> products) {
        List<Product> models = new ArrayList<>();
        for (ProductWithCategoriesModel product : products) {
            models.add(toEntity(product));
        }
        return models;
    }
}
