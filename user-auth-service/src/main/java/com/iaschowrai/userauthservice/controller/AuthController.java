package com.iaschowrai.userauthservice.controller;

import com.iaschowrai.userauthservice.controller.model.AuthRequestDto;
import com.iaschowrai.userauthservice.controller.model.AuthResponseDto;
import com.iaschowrai.userauthservice.service.auth.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    private final AuthService authService;
    @PostMapping("/signup")
    public ResponseEntity<AuthResponseDto> signUp(@RequestBody AuthRequestDto authRequest){
        authService.
    }
}
