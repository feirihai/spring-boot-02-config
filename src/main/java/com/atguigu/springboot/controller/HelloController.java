package com.atguigu.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("${person.lastName}")
    private String name;

    @RequestMapping("/sayhello")
    public String sayHello(){
        return "Hello" + name;
    }
}
