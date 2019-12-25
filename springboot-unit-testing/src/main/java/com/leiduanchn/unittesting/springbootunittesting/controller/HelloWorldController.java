package com.leiduanchn.unittesting.springbootunittesting.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author leiduanchn
 * @create 2019-12-24 10:34 p.m.
 */
@RestController
public class HelloWorldController {

    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello World!";
    }
}
