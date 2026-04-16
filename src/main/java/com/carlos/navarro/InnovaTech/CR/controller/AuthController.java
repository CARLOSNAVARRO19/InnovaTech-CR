package com.carlos.navarro.InnovaTech.CR.controller;

import com.carlos.navarro.InnovaTech.CR.dto.LoginRequest;
import com.carlos.navarro.InnovaTech.CR.dto.RegisterRequest;
import com.carlos.navarro.InnovaTech.CR.dto.RegisterResponse;
import com.carlos.navarro.InnovaTech.CR.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(
            @RequestBody RegisterRequest request) {

        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(
            @RequestBody LoginRequest request) {

        return ResponseEntity.ok(authService.login(request));
    }
}
