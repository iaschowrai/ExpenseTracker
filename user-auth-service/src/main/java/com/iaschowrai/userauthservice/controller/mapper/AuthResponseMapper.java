package com.iaschowrai.userauthservice.controller.mapper;

import com.iaschowrai.userauthservice.controller.model.AuthRequestDto;
import com.iaschowrai.userauthservice.controller.model.AuthResponseDto;
import com.iaschowrai.userauthservice.service.model.AuthRequest;
import com.iaschowrai.userauthservice.service.model.AuthResponse;
import org.mapstruct.factory.Mappers;

public interface AuthResponseMapper {

    AuthResponseMapper INSTANCE = Mappers.getMapper(AuthResponseMapper.class);

    // Return type -> Target
    // Parameter -> Source

    AuthResponseDto toAuthResponseDto(AuthResponse authResponse);

}
