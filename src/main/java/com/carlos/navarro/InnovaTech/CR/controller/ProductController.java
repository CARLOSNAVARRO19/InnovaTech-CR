package com.carlos.navarro.InnovaTech.CR.controller;

import com.carlos.navarro.InnovaTech.CR.dto.ProductRequest;
import com.carlos.navarro.InnovaTech.CR.dto.ProductResponse;
import com.carlos.navarro.InnovaTech.CR.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAll() {
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getById(id));
    }

    @PostMapping
    public ResponseEntity<ProductResponse> create(
            @RequestBody ProductRequest request) {

        return ResponseEntity.ok(productService.create(request));
    }
}
