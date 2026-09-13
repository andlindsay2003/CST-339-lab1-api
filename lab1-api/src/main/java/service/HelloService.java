package service;

import org.springframework.stereotype.Service;

import dto.HelloResponse;

@Service
public class HelloService {
    public HelloResponse getHello()
    {
        return new HelloResponse("Hello Spring Boot");
    }
}
