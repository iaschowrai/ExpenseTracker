package com.iaschowrai.userauthservice.controller;

import com.iaschowrai.userauthservice.controller.mapper.AuthRequestMapper;
import com.iaschowrai.userauthservice.controller.mapper.AuthResponseMapper;
import com.iaschowrai.userauthservice.controller.model.AuthRequestDto;
import com.iaschowrai.userauthservice.controller.model.AuthResponseDto;
import com.iaschowrai.userauthservice.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
//@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<AuthResponseDto> signUp(@RequestBody AuthRequestDto authRequestDto){
        var authResponse = authService.signUp(AuthRequestMapper.INSTANCE.toAuthRequest(authRequestDto));
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(AuthResponseMapper.INSTANCE.toAuthResponseDto(authResponse));
    }
}
