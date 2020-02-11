package com.fbiankevin.jwtauthenticationsample.persistence.repository;

import com.fbiankevin.jwtauthenticationsample.model.UserCredentials;
import com.fbiankevin.jwtauthenticationsample.persistence.entity.UserCredentialsEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserCredentialsRepository extends MongoRepository<UserCredentialsEntity, String> {
    Optional<UserCredentialsEntity> findByUsername(String username);
}
