package com.fbiankevin.jwtauthenticationsample.request;

import lombok.Data;

@Data
public class UserForm {
    private String lastName;
    private String firstName;
    private String middleName;
    private UserCredentialsForm credentials;
}
