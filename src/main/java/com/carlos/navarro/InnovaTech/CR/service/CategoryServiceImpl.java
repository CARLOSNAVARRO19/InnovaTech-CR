package com.carlos.navarro.InnovaTech.CR.service;

import com.carlos.navarro.InnovaTech.CR.dto.CategoryRequest;
import com.carlos.navarro.InnovaTech.CR.dto.CategoryResponse;
import com.carlos.navarro.InnovaTech.CR.mapper.CategoryMapper;
import com.carlos.navarro.InnovaTech.CR.model.Category;
import com.carlos.navarro.InnovaTech.CR.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryResponse create(CategoryRequest request) {

        Category category = categoryMapper.toEntity(request);

        categoryRepository.save(category);

        return categoryMapper.toResponse(category);
    }

    @Override
    public List<CategoryResponse> getAll() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toResponse)
                .toList();
    }
}
