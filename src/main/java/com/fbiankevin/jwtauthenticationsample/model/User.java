package com.fbiankevin.jwtauthenticationsample.model;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String lastName;
    private String firstName;
    private String middleName;
    private UserCredentials credentials;
}
