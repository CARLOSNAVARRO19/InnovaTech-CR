package com.carlos.navarro.InnovaTech.CR.mapper;

import com.carlos.navarro.InnovaTech.CR.dto.CategoryRequest;
import com.carlos.navarro.InnovaTech.CR.dto.CategoryResponse;
import com.carlos.navarro.InnovaTech.CR.model.Category;

public class CategoryMapper {
    public Category toEntity(CategoryRequest request) {
        Category category = new Category();
        category.setName(request.getName());
        return category;
    }

    public CategoryResponse toResponse(Category category) {
        CategoryResponse response = new CategoryResponse();
        response.setId(category.getId());
        response.setName(category.getName());
        return response;
    }
}
