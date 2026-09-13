package main.java.com.gcu.lab1_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.HelloResponse;
import service.HelloService;

@RestController
public class HelloController {

    private final HelloService helloService;

    public HelloController(HelloService helloService)
    {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public HelloResponse hello()
    {
        return helloService.getHello();
    }
}
