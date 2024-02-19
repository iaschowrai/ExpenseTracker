package com.iaschowrai.userauthservice.data.repo;

import com.iaschowrai.userauthservice.data.model.AppUser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AppUserRepo extends MongoRepository<AppUser,String> {

    boolean existsByEmail(String email);
}
