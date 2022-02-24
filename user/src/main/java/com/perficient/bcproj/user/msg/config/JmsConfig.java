//package com.perficient.bcproj.user.msg.config;

/*
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.*;

@Configuration
public class JmsConfig {
    public static final String VALIDATE_USER_QUEUE= "validate-user";
    public static final String VALIDATE_USER_RESPONSE_QUEUE = "validate-user-response";

    @Bean
    public MappingJackson2MessageConverter messageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        //converter.setObjectMapper(objectMapper);
        return converter;
    }
}
*/