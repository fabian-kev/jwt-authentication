package com.fbiankevin.jwtauthenticationsample.request;

import lombok.Data;

@Data
public class UserCredentialsForm {
    private String username;
    private String password;
}
