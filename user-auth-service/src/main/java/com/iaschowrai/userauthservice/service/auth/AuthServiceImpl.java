package com.iaschowrai.userauthservice.service.auth;

import com.iaschowrai.userauthservice.data.model.AppUser;
import com.iaschowrai.userauthservice.data.repo.AppUserRepo;
import com.iaschowrai.userauthservice.exception.UserAlreadyExistsException;
import com.iaschowrai.userauthservice.service.model.AuthRequest;
import com.iaschowrai.userauthservice.service.model.AuthResponse;
import com.iaschowrai.userauthservice.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
    private final AppUserRepo appUserRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public AuthResponse signUp(AuthRequest authRequest) {
        //  Check the email address is exist or not
        if(appUserRepo.existsByEmail(authRequest.getEmail())){
            throw new UserAlreadyExistsException("Email Already Exists!!");
        }
        // password encoder
        var encodePassword = passwordEncoder.encode(authRequest.getPassword());

        //  Create App user
        var appUser = AppUser.builder()
                .name(authRequest.getName())
                .email(authRequest.getEmail())
                .password(encodePassword)
                .build();

        //  Save the user
        appUserRepo.save(appUser);

        var accessToken = JwtUtils.generateAccessToken(authRequest.getEmail());

        return AuthResponse.builder()
                .accessToken(accessToken)
                .build();
    }
}
