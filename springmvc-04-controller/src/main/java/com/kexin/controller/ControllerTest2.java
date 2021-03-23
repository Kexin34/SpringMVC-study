package com.kexin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller注解的类会自动添加到Spring上下文中
@Controller   // 代表这个类会被spring接管
// 被这个注解的类，中的所有方法，如果返回值是string，并且有具体页面可以跳转，就会被摄图解析器解析
public class ControllerTest2{

    //映射访问路径
    @RequestMapping("/t2")
    public String test1(Model model){
        //Spring MVC会自动实例化一个Model对象用于向视图中传值
        model.addAttribute("msg", "ControllerTest2");

        //返回视图位置
        return "test";
    }

}