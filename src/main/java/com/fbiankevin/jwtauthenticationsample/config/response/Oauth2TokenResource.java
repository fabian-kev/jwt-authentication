package com.fbiankevin.jwtauthenticationsample.config.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Oauth2TokenResource {
    private String token;
    private String username;
}
