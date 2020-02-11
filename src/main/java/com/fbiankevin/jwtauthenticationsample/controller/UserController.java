package com.fbiankevin.jwtauthenticationsample.controller;

import com.fbiankevin.jwtauthenticationsample.interactor.CreateUser;
import com.fbiankevin.jwtauthenticationsample.persistence.entity.UserEntity;
import com.fbiankevin.jwtauthenticationsample.persistence.repository.UserCredentialsRepository;
import com.fbiankevin.jwtauthenticationsample.persistence.repository.UserRepository;
import com.fbiankevin.jwtauthenticationsample.request.UserForm;
import com.fbiankevin.jwtauthenticationsample.response.UserResource;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@Slf4j
@RequestMapping("/users")
public class UserController {

    private final CreateUser createUser;
    private final UserCredentialsRepository userCredentialsRepository;

    @PostMapping
    UserResource create(@RequestBody UserForm userForm) {
        log.debug("user form "+userForm);
        return createUser.execute(userForm);
    }


    @GetMapping("/{email}")
    ResponseEntity get(@PathVariable String email){
        return ResponseEntity.ok(userCredentialsRepository.findByUsername(email)
        .orElseThrow(() -> new RuntimeException("Unable to find email "+email)));
    }
}
