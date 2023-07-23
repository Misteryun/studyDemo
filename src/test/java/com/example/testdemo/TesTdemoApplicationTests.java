package com.example.testdemo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.example.testdemo.entity.TUser;
import com.example.testdemo.mapper.TUserMapper;
import com.example.testdemo.service.TUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TesTdemoApplicationTests {

    @Autowired
    private TUserService tUserService;


    /**
     * 序列化对象
     */
    @Test
    void contextLoads() {
         List<TUser> list = tUserService.list();
         String s = JSON.toJSONString(list);
         System.out.println(s);
    }



}
