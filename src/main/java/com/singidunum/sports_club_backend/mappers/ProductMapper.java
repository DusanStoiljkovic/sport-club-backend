package com.singidunum.sports_club_backend.mappers;

import java.util.ArrayList;
import java.util.List;
import com.singidunum.sports_club_backend.entities.Product;
import com.singidunum.sports_club_backend.models.ProductModel;

public class ProductMapper {
    public static ProductModel toModel(Product entity) {
        return ProductModel.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    public static List<ProductModel> toModelList(List<Product> entities) {
        var list = new ArrayList<ProductModel>();
        for(Product entity : entities) {
            list.add(toModel(entity));
        }
        return list;
    }

    public static Product toEntity(ProductModel entity) {
        Product product = new Product();
        product.setName(entity.getName());
        return product;
    }

    public static List<Product> toEntityList(List<ProductModel> products) {
        var list = new ArrayList<Product>();
        for(ProductModel entity : products) {
            list.add(toEntity(entity));
        }
        return list;
    }
}
