package com.kexin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EncodingController {

    // 过滤器解决乱码
    @PostMapping("/e/t")
    public String test(Model model, String name){
        model.addAttribute("msg",name); //获取表单提交的值
        return "hello"; //跳转到test页面显示输入的值
    }
}