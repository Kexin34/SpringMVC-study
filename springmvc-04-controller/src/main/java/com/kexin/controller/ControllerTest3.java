package com.kexin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class ControllerTest3 {
    @RequestMapping("/h1")
    public String test(){
        return "test";
    }
}
