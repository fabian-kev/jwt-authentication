package com.fbiankevin.jwtauthenticationsample.persistence.repository;

import com.fbiankevin.jwtauthenticationsample.persistence.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {
}
