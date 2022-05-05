package com.myweb.firsit.controller;

import com.myweb.firsit.domain.Test;
import com.myweb.firsit.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @Resource
    private TestService testService;

    @GetMapping("/hello")

    public String hello(){
            return "Hello World!";
        }
    @PostMapping ("/hello/post")

    public String helloPost(String name){
        return "Hello World! Post "+name;
    }
    @GetMapping("/test/list")
    public List<Test> list(){
        return testService.list();
    }
    }
