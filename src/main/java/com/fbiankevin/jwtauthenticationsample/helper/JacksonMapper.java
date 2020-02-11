package com.fbiankevin.jwtauthenticationsample.helper;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public final class JacksonMapper {
    private ObjectMapper objectMapper;



    public JacksonMapper(){
        objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public <T> T map(Object o, Class<T> clazz) {
        return objectMapper.convertValue(o, clazz);
    }
}
