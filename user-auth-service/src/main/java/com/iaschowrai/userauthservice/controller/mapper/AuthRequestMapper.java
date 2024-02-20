package com.iaschowrai.userauthservice.controller.mapper;

import com.iaschowrai.userauthservice.controller.model.AuthRequestDto;
import com.iaschowrai.userauthservice.service.model.AuthRequest;
import org.mapstruct.factory.Mappers;

public interface AuthRequestMapper {

    AuthRequestMapper INSTANCE = Mappers.getMapper(AuthRequestMapper.class);

    // Return type -> Target
    // Parameter -> Source

    AuthRequest toAuthRequest(AuthRequestDto authRequestDto);

}
