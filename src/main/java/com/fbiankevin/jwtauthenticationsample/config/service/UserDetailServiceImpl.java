package com.fbiankevin.jwtauthenticationsample.config.service;

import com.fbiankevin.jwtauthenticationsample.persistence.repository.UserCredentialsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component("CustomUserDetailsService")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@Slf4j
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserCredentialsRepository userCredentialsRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.debug("Signing in.. "+username);
        return userCredentialsRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User doesn't exists"));
    }
}
