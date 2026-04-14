package com.carlos.navarro.InnovaTech.CR.repository;

import com.carlos.navarro.InnovaTech.CR.model.Order;
import com.carlos.navarro.InnovaTech.CR.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findByOrder(Order order);
}
