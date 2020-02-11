package com.fbiankevin.jwtauthenticationsample.interactor;

import com.fbiankevin.jwtauthenticationsample.request.UserForm;
import com.fbiankevin.jwtauthenticationsample.response.UserResource;


public interface CreateUser {
    UserResource execute(UserForm userForm);
}
