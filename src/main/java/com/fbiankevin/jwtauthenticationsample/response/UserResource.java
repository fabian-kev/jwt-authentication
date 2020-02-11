package com.fbiankevin.jwtauthenticationsample.response;

import lombok.Data;

@Data
public class UserResource {
    private String lastName;
    private String firstName;
    private String middleName;
}
