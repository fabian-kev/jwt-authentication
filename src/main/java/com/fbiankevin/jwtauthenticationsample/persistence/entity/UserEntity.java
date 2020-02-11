package com.fbiankevin.jwtauthenticationsample.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
@Data
@Document(collection = "users")
@TypeAlias("User")
public class UserEntity {
    @Id
    private String id;
    private String lastName;
    private String firstName;
    private String middleName;

    @DBRef
    private UserCredentialsEntity credentials;
}
