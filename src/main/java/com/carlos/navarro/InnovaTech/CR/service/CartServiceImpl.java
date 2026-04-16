package com.carlos.navarro.InnovaTech.CR.service;

import com.carlos.navarro.InnovaTech.CR.dto.CartItemResponse;
import com.carlos.navarro.InnovaTech.CR.dto.CartResponse;
import com.carlos.navarro.InnovaTech.CR.mapper.CartMapper;
import com.carlos.navarro.InnovaTech.CR.model.CartItem;
import com.carlos.navarro.InnovaTech.CR.model.Product;
import com.carlos.navarro.InnovaTech.CR.model.User;
import com.carlos.navarro.InnovaTech.CR.repository.CartItemRepository;
import com.carlos.navarro.InnovaTech.CR.repository.ProductRepository;
import com.carlos.navarro.InnovaTech.CR.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor

@Service
public class CartServiceImpl implements CartService {

    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final CartMapper cartMapper;

    private User getCurrentUser() {
        String email = (String) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();

        return userRepository.findByEmail(email).orElseThrow();
    }

    @Override
    public void addToCart(Long productId, Integer quantity) {

        User user = getCurrentUser();

        Product product = productRepository.findById(productId)
                .orElseThrow();

        CartItem item = cartItemRepository
                .findByUserAndProduct(user, product)
                .orElse(null);

        if (item == null) {
            item = new CartItem();
            item.setUser(user);
            item.setProduct(product);
            item.setQuantity(quantity);
        } else {
            item.setQuantity(item.getQuantity() + quantity);
        }
        cartItemRepository.save(item);
    }

    @Override
    public CartResponse getCart() {

        User user = getCurrentUser();

        List<CartItem> items = cartItemRepository.findByUser(user);

        List<CartItemResponse> responseItems = items.stream()
                .map(cartMapper::toResponse)
                .toList();

        double total = responseItems.stream()
                .mapToDouble(CartItemResponse::getSubtotal)
                .sum();

        CartResponse response = new CartResponse();
        response.setItems(responseItems);
        response.setTotal(total);

        return response;
    }

    @Override
    public void removeItem(Long productId) {

        User user = getCurrentUser();

        Product product = productRepository.findById(productId)
                .orElseThrow();

        CartItem item = cartItemRepository
                .findByUserAndProduct(user, product)
                .orElseThrow();

        cartItemRepository.delete(item);
    }
}
