package com.carlos.navarro.InnovaTech.CR.repository;

import com.carlos.navarro.InnovaTech.CR.model.Order;
import com.carlos.navarro.InnovaTech.CR.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);
}
