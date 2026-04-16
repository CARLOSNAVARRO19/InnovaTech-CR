package com.carlos.navarro.InnovaTech.CR.controller;

import com.carlos.navarro.InnovaTech.CR.dto.CartItemRequest;
import com.carlos.navarro.InnovaTech.CR.dto.CartResponse;
import com.carlos.navarro.InnovaTech.CR.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<String> addToCart(
            @RequestBody CartItemRequest request) {

        cartService.addToCart(request.getProductId(), request.getQuantity());

        return ResponseEntity.ok("Product added to cart");
    }

    @GetMapping
    public ResponseEntity<CartResponse> getCart() {

        return ResponseEntity.ok(cartService.getCart());
    }

    @DeleteMapping("/remove")
    public ResponseEntity<String> removeItem(
            @RequestParam Long productId) {

        cartService.removeItem(productId);

        return ResponseEntity.ok("Item removed from cart");
    }
}
