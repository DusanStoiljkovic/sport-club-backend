package com.singidunum.sports_club_backend.controllers;

import com.singidunum.sports_club_backend.mappers.CategoryMapper;
import com.singidunum.sports_club_backend.mappers.CategoryWithProductsMapper;
import com.singidunum.sports_club_backend.models.CategoryModel;
import com.singidunum.sports_club_backend.models.CategoryWithProductsModel;
import com.singidunum.sports_club_backend.repositories.ICategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {
    private final ICategoryRepository categoryRepository;

    public CategoryController(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public List<CategoryWithProductsModel> getCategoryList() {
        return CategoryWithProductsMapper.toModelList(categoryRepository.findAll());
    }
}
