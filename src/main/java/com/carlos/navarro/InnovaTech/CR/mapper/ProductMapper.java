package com.carlos.navarro.InnovaTech.CR.mapper;

import com.carlos.navarro.InnovaTech.CR.dto.ProductRequest;
import com.carlos.navarro.InnovaTech.CR.dto.ProductResponse;
import com.carlos.navarro.InnovaTech.CR.model.Category;
import com.carlos.navarro.InnovaTech.CR.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product toEntity(ProductRequest request, Category category) {
        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());
        product.setImageUrl(request.getImageUrl());
        product.setCategory(category);
        return product;
    }

    public ProductResponse toResponse(Product product) {
        ProductResponse response = new ProductResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setDescription(product.getDescription());
        response.setPrice(product.getPrice());
        response.setStock(product.getStock());
        response.setImageUrl(product.getImageUrl());
        response.setCategoryName(product.getCategory().getName());
        return response;
    }
}
