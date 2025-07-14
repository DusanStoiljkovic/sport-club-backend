package com.singidunum.sports_club_backend.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryModel {
    private Integer id;
    private String name;
}
