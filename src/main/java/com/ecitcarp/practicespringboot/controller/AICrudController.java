package com.ecitcarp.practicespringboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/AI")
public class AICrudController {

    @GetMapping("/call")
    public String callAI(){
        return "Hello From AI.....";
    }
}
