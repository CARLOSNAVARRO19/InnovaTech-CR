package com.carlos.navarro.InnovaTech.CR.mapper;

import com.carlos.navarro.InnovaTech.CR.dto.OrderItemResponse;
import com.carlos.navarro.InnovaTech.CR.dto.OrderResponse;
import com.carlos.navarro.InnovaTech.CR.model.Order;
import com.carlos.navarro.InnovaTech.CR.model.OrderItem;

import java.util.List;

public class OrderMapper {
    public OrderItemResponse toItemResponse(OrderItem item) {
        OrderItemResponse dto = new OrderItemResponse();

        dto.setProductId(item.getProduct().getId());
        dto.setProductName(item.getProduct().getName());
        dto.setQuantity(item.getQuantity());
        dto.setPrice(item.getPrice());

        double subtotal = item.getPrice() * item.getQuantity();
        dto.setSubtotal(subtotal);

        return dto;
    }

    public OrderResponse toResponse(Order order, List<OrderItem> items) {

        List<OrderItemResponse> itemResponses = items.stream()
                .map(this::toItemResponse)
                .toList();

        double total = itemResponses.stream()
                .mapToDouble(i -> i.getSubtotal())
                .sum();

        OrderResponse response = new OrderResponse();
        response.setOrderId(order.getId());
        response.setItems(itemResponses);
        response.setTotal(total);

        return response;
    }
}
