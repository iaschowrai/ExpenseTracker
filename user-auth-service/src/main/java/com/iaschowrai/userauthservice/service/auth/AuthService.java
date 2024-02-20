package com.iaschowrai.userauthservice.service.auth;

import com.iaschowrai.userauthservice.service.model.AuthRequest;
import com.iaschowrai.userauthservice.service.model.AuthResponse;

public interface AuthService {

    AuthResponse signUp(AuthRequest authRequest);
}
