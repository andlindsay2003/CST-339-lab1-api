package com.gcu.lab1_api.service;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gcu.lab1_api.dto.HelloResponse;

@Service
public class HelloService {

    private static final Logger logger = LoggerFactory.getLogger(HelloService.class);

    public HelloResponse getHello()
    {
        logger.info("Building HelloResponse object");
        return new HelloResponse("Hello Spring Boot");
    }
}
