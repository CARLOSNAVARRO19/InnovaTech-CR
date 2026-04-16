package com.carlos.navarro.InnovaTech.CR.service;

import com.carlos.navarro.InnovaTech.CR.dto.ProductRequest;
import com.carlos.navarro.InnovaTech.CR.dto.ProductResponse;
import com.carlos.navarro.InnovaTech.CR.exception.NotFoundException;
import com.carlos.navarro.InnovaTech.CR.mapper.ProductMapper;
import com.carlos.navarro.InnovaTech.CR.model.Category;
import com.carlos.navarro.InnovaTech.CR.model.Product;
import com.carlos.navarro.InnovaTech.CR.repository.CategoryRepository;
import com.carlos.navarro.InnovaTech.CR.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;

    @Override
    public List<ProductResponse> getAll() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toResponse)
                .toList();
    }

    @Override
    public ProductResponse getById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found with id: " + id));
        return productMapper.toResponse(product);
    }

    @Override
    public ProductResponse create(ProductRequest request) {

        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new NotFoundException("Category not found with id: " + request.getCategoryId()));

        Product product = productMapper.toEntity(request, category);

        productRepository.save(product);

        return productMapper.toResponse(product);
    }
}
