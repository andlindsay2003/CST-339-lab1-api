package main.java.com.gcu.lab1_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dto.HelloResponse;
import service.HelloService;

@RestController
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class)

    private final HelloService helloService;

    public HelloController(HelloService helloService)
    {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public HelloResponse hello()
    {
        logger.info("Received request for /hello");
        return helloService.getHello();
    }
}
