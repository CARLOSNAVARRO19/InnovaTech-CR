package com.carlos.navarro.InnovaTech.CR.mapper;

import com.carlos.navarro.InnovaTech.CR.dto.ProductRequest;
import com.carlos.navarro.InnovaTech.CR.dto.ProductResponse;
import com.carlos.navarro.InnovaTech.CR.model.Category;
import com.carlos.navarro.InnovaTech.CR.model.Product;

public class ProductMapper {
    public Product toEntity(ProductRequest request, Category category) {
        Product product = new Product();
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());
        product.setCategory(category);
        return product;
    }

    public ProductResponse toResponse(Product product) {
        ProductResponse response = new ProductResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setPrice(product.getPrice());
        response.setStock(product.getStock());
        response.setCategoryName(product.getCategory().getName());
        return response;
    }
}
