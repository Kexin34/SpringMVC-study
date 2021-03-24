package com.kexin.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.kexin.pojo.User;
import com.kexin.utils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Controller
//public class UserController {
//    @RequestMapping("/json1")
//    @ResponseBody  // 有了这个注解，它就不会走视图解析器，会直接返回一个字符串
//    public String json1() throws JsonProcessingException {
//
//        //创建一个jackson的对象映射器，用来解析数据
//        ObjectMapper mapper = new ObjectMapper();
//
//        //创建一个对象
//        User user = new User("秦疆1号", 3, "男");
//
//        //将我们的对象解析成为json格式
//        String str = mapper.writeValueAsString(user);
//
//        //由于@ResponseBody注解，这里会将str转成json格式返回；十分方便
//        return str;
//    }
//}

@RestController
public class UserController {

    //produces:指定响应体返回类型和编码
    @RequestMapping(value = "/json1")
    public String json1() throws JsonProcessingException {
        //创建一个jackson的对象映射器，用来解析数据
        ObjectMapper mapper = new ObjectMapper();
        //创建一个对象
        User user = new User("秦疆1号", 3, "男");
        //将我们的对象解析成为json格式
        String str = mapper.writeValueAsString(user);
        //由于@ResponseBody注解，这里会将str转成json格式返回；十分方便
        return str;
    }

    // 测试集合输出
    @RequestMapping("/json2")
    public String json2() throws JsonProcessingException {

        //创建一个jackson的对象映射器，用来解析数据
        ObjectMapper mapper = new ObjectMapper();
        //创建一个对象
        User user1 = new User("秦疆1号", 3, "男");
        User user2 = new User("秦疆2号", 3, "男");
        User user3 = new User("秦疆3号", 3, "男");
        User user4 = new User("秦疆4号", 3, "男");
        List<User> list = new ArrayList<User>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);

        //将我们的对象解析成为json格式
        String str = mapper.writeValueAsString(list);
        return str;
    }

    // 输出时间对象
    @RequestMapping("/json3")
    public String json3() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        //创建时间一个对象，java.util.Date
        Date date = new Date();

        //将我们的对象解析成为json格式
        String str = mapper.writeValueAsString(date);
        return str;
    }

    // 自定义时间格式
    @RequestMapping("/json4")
    public String json4() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        //mapper配置中，不使用时间戳的方式
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        //自定义日期格式对象 (SimpleDateFormat属于java基础知识）
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //指定日期格式
        mapper.setDateFormat(sdf);

        Date date = new Date();
        String str = mapper.writeValueAsString(date);

        return str;
    }

    @RequestMapping("/json5")
    public String json5() throws JsonProcessingException {
        Date date = new Date();
        String json = JsonUtils.getJson(date);
        return json;
    }

    @RequestMapping("/j6")
    public void json6() throws JsonProcessingException {
        //创建一个对象
        User user1 = new User("秦疆1号", 3, "男");
        User user2 = new User("秦疆2号", 3, "男");
        User user3 = new User("秦疆3号", 3, "男");
        User user4 = new User("秦疆4号", 3, "男");
        List<User> list = new ArrayList<User>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);

        System.out.println("*******Java对象 转 JSON字符串*******");
        String str1 = JSON.toJSONString(list);
        System.out.println("JSON.toJSONString(list)==>"+str1);
        String str2 = JSON.toJSONString(user1);
        System.out.println("JSON.toJSONString(user1)==>"+str2);

        System.out.println("\n****** JSON字符串 转 Java对象*******");
        User jp_user1=JSON.parseObject(str2, User.class);
        System.out.println("JSON.parseObject(str2,User.class)==>"+jp_user1);

        System.out.println("\n****** Java对象 转 JSON对象 ******");
        JSONObject jsonObject1 = (JSONObject) JSON.toJSON(user2);
        System.out.println("(JSONObject) JSON.toJSON(user2)==>"+jsonObject1.getString("name"));

        System.out.println("\n****** JSON对象 转 Java对象 ******");
        User to_java_user = JSON.toJavaObject(jsonObject1, User.class);
        System.out.println("JSON.toJavaObject(jsonObject1, User.class)==>"+to_java_user);
    }


}