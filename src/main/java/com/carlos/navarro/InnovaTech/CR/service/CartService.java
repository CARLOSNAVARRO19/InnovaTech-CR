package com.carlos.navarro.InnovaTech.CR.service;

import com.carlos.navarro.InnovaTech.CR.dto.CartResponse;

public interface CartService {
    void addToCart(Long productId, Integer quantity);
    CartResponse getCart();
    void removeItem(Long productId);
}
