package com.fbiankevin.jwtauthenticationsample.config.request;

import lombok.Data;

@Data
public class Oauth2LoginForm {
    private String username;
    private String password;
    private String grantType;
}
