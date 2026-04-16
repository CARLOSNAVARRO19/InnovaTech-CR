package com.carlos.navarro.InnovaTech.CR.service;

import com.carlos.navarro.InnovaTech.CR.dto.OrderResponse;
import com.carlos.navarro.InnovaTech.CR.mapper.OrderMapper;
import com.carlos.navarro.InnovaTech.CR.model.CartItem;
import com.carlos.navarro.InnovaTech.CR.model.Order;
import com.carlos.navarro.InnovaTech.CR.model.OrderItem;
import com.carlos.navarro.InnovaTech.CR.model.User;
import com.carlos.navarro.InnovaTech.CR.repository.CartItemRepository;
import com.carlos.navarro.InnovaTech.CR.repository.OrderItemRepository;
import com.carlos.navarro.InnovaTech.CR.repository.OrderRepository;
import com.carlos.navarro.InnovaTech.CR.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor

@Service
public class OrderServiceImpl implements OrderService {

    private final CartItemRepository cartItemRepository;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final UserRepository userRepository;
    private final OrderMapper orderMapper;

    private User getCurrentUser() {
        String email = (String) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();

        return userRepository.findByEmail(email).orElseThrow();
    }

    @Override
    public OrderResponse checkout() {

        User user = getCurrentUser();

        List<CartItem> cartItems = cartItemRepository.findByUser(user);


        if (cartItems.isEmpty()) {
            throw new RuntimeException("Cart is empty");
        }

        Order order = new Order();
        order.setUser(user);
        order.setTotal(0.0);

        orderRepository.save(order);

        List<OrderItem> orderItems = new ArrayList<>();
        double total = 0;

        for (CartItem cartItem : cartItems) {

            OrderItem item = new OrderItem();
            item.setOrder(order);
            item.setProduct(cartItem.getProduct());
            item.setQuantity(cartItem.getQuantity());
            item.setPrice(cartItem.getProduct().getPrice());

            total += item.getPrice() * item.getQuantity();

            orderItems.add(item);
        }

        orderItemRepository.saveAll(orderItems);

        order.setTotal(total);
        orderRepository.save(order);

        cartItemRepository.deleteAll(cartItems);

        return orderMapper.toResponse(order, orderItems);
    }
}
