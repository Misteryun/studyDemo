package com.example.testdemo.controller;


import com.example.testdemo.entity.TUser;
import com.example.testdemo.mapper.TUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author author
 * @since 2023-07-21
 */
@RestController
@RequestMapping("/t-user")
public class TUserController {
    @Autowired
    private TUserMapper tUserMapper;

   @GetMapping("/test1")
    public void test(){
        Map<String, Object> stringObjectMap = tUserMapper.selectList1();
        System.out.println(stringObjectMap);
   }

}
