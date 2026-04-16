package com.carlos.navarro.InnovaTech.CR.service;

import com.carlos.navarro.InnovaTech.CR.dto.LoginRequest;
import com.carlos.navarro.InnovaTech.CR.dto.RegisterRequest;
import com.carlos.navarro.InnovaTech.CR.dto.RegisterResponse;
import com.carlos.navarro.InnovaTech.CR.exception.NotFoundException;
import com.carlos.navarro.InnovaTech.CR.mapper.UserMapper;
import com.carlos.navarro.InnovaTech.CR.model.User;
import com.carlos.navarro.InnovaTech.CR.repository.UserRepository;
import com.carlos.navarro.InnovaTech.CR.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final UserMapper userMapper;

    @Override
    public RegisterResponse register(RegisterRequest request) {
        User user = userMapper.toEntity(request);

        userRepository.save(user);

        return userMapper.toResponse(user);
    }

    @Override
    public String login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return jwtService.generateToken(user.getEmail());
    }
}
