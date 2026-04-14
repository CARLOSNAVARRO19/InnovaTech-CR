package com.carlos.navarro.InnovaTech.CR.repository;

import com.carlos.navarro.InnovaTech.CR.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserRepository, Long> {
    Optional<User> findByEmail(String email);
}
