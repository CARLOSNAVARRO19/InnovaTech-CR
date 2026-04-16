package com.carlos.navarro.InnovaTech.CR.service;

import com.carlos.navarro.InnovaTech.CR.dto.CategoryRequest;
import com.carlos.navarro.InnovaTech.CR.dto.CategoryResponse;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService {
    CategoryResponse create(CategoryRequest request);
    List<CategoryResponse> getAll();
}
