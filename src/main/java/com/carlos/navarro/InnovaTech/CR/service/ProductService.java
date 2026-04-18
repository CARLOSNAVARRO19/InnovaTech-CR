package com.carlos.navarro.InnovaTech.CR.service;

import com.carlos.navarro.InnovaTech.CR.dto.ProductRequest;
import com.carlos.navarro.InnovaTech.CR.dto.ProductResponse;
import com.carlos.navarro.InnovaTech.CR.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ProductService {
    Page<ProductResponse> getAll(int page, int size, String sortDir);

    ProductResponse getById(Long id);
    ProductResponse create(ProductRequest request);

    List<ProductResponse> getByCategory(Long categoryId, String sortDir);
    List<ProductResponse> search(String keyword);
}
