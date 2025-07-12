package com.singidunum.sports_club_backend.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserPageModel {
    private List<UserModel> users;
    private int totalElements;
    private Long totalPages;
}
