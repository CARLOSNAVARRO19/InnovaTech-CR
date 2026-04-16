package com.carlos.navarro.InnovaTech.CR.controller;

import com.carlos.navarro.InnovaTech.CR.dto.OrderResponse;
import com.carlos.navarro.InnovaTech.CR.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/checkout")
    public ResponseEntity<OrderResponse> checkout() {

        return ResponseEntity.ok(orderService.checkout());
    }
}
