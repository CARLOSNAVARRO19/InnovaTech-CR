package com.carlos.navarro.InnovaTech.CR.service;

import com.carlos.navarro.InnovaTech.CR.dto.LoginRequest;
import com.carlos.navarro.InnovaTech.CR.dto.RegisterRequest;
import com.carlos.navarro.InnovaTech.CR.dto.RegisterResponse;

public interface AuthService {
    RegisterResponse register(RegisterRequest request);

    String login(LoginRequest request);
}
