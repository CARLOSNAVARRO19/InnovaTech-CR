package com.carlos.navarro.InnovaTech.CR.mapper;

import com.carlos.navarro.InnovaTech.CR.dto.CartItemResponse;
import com.carlos.navarro.InnovaTech.CR.model.CartItem;
import org.springframework.stereotype.Component;

@Component
public class CartMapper {
    public CartItemResponse toResponse(CartItem item) {
        CartItemResponse dto = new CartItemResponse();

        dto.setProductId(item.getProduct().getId());
        dto.setProductName(item.getProduct().getName());
        dto.setPrice(item.getProduct().getPrice());
        dto.setQuantity(item.getQuantity());

        double subtotal = item.getProduct().getPrice() * item.getQuantity();
        dto.setSubtotal(subtotal);

        return dto;
    }
}
