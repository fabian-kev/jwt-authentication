package com.fbiankevin.jwtauthenticationsample.config.controller;

import com.fbiankevin.jwtauthenticationsample.config.request.Oauth2LoginForm;
import com.fbiankevin.jwtauthenticationsample.config.response.Oauth2TokenResource;
import com.fbiankevin.jwtauthenticationsample.helper.JwtTokenUtil;
import com.fbiankevin.jwtauthenticationsample.persistence.entity.UserCredentialsEntity;
import com.fbiankevin.jwtauthenticationsample.persistence.repository.UserCredentialsRepository;
import com.fbiankevin.jwtauthenticationsample.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oauth")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class AuthenticationController {


    private final AuthenticationManager authenticationManager;
    private final UserCredentialsRepository userCredentialsRepository;
    private final JwtTokenUtil jwtTokenUtil;

    @PostMapping("/token")
    public Oauth2TokenResource login(@RequestBody Oauth2LoginForm form) throws AuthenticationException {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(form.getUsername(), form.getPassword()));
        UserCredentialsEntity credentialsEntity = userCredentialsRepository.findByUsername(form.getUsername()).get();

        String token = jwtTokenUtil.generateToken(credentialsEntity);
        return new Oauth2TokenResource(token, form.getUsername());
    }
}
