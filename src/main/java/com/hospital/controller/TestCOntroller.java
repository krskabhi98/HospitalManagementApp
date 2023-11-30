package com.hospital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestCOntroller {

    @GetMapping("/test")
    @ResponseBody
    public String testController(){
        return "Hello Testing";
    }
}
