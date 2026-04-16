package com.carlos.navarro.InnovaTech.CR.controller;

import com.carlos.navarro.InnovaTech.CR.dto.CategoryRequest;
import com.carlos.navarro.InnovaTech.CR.dto.CategoryResponse;
import com.carlos.navarro.InnovaTech.CR.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAll() {
        return ResponseEntity.ok(categoryService.getAll());
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> create(
            @RequestBody CategoryRequest request) {

        return ResponseEntity.ok(categoryService.create(request));
    }
}
