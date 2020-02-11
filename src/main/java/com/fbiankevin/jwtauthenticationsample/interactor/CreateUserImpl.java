package com.fbiankevin.jwtauthenticationsample.interactor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fbiankevin.jwtauthenticationsample.helper.JacksonMapper;
import com.fbiankevin.jwtauthenticationsample.model.UserCredentials;
import com.fbiankevin.jwtauthenticationsample.persistence.entity.UserCredentialsEntity;
import com.fbiankevin.jwtauthenticationsample.persistence.entity.UserEntity;
import com.fbiankevin.jwtauthenticationsample.persistence.repository.UserCredentialsRepository;
import com.fbiankevin.jwtauthenticationsample.persistence.repository.UserRepository;
import com.fbiankevin.jwtauthenticationsample.request.UserForm;
import com.fbiankevin.jwtauthenticationsample.response.UserResource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@Slf4j
public class CreateUserImpl implements CreateUser {
    private final UserRepository userRepository;
    private final UserCredentialsRepository userCredentialsRepository;
    private final JacksonMapper jacksonMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public UserResource execute(UserForm userForm) {
        UserEntity userEntity = jacksonMapper.map(userForm, UserEntity.class);
        System.out.println(userEntity.toString());
//        log.debug("user "+userEntity.toString());



        UserCredentialsEntity userCredentialsEntity = userEntity.getCredentials();
        userCredentialsEntity.setAuthorities("admin,super_admin");

        UserCredentialsEntity userCredentials = userCredentialsRepository.save(userCredentialsEntity);
        userCredentials.setPassword( bCryptPasswordEncoder.encode( userCredentials.getPassword() ) );
        userEntity.setCredentials(userCredentials);

        userEntity = userRepository.save(userEntity);

        userCredentials.setUser(userEntity);

        userCredentialsRepository.save(userCredentialsEntity);

        UserResource resource = jacksonMapper.map(userRepository.save(userEntity), UserResource.class);


        return resource;
    }
}
