package com.example.testdemo.controller;


import cn.hutool.json.JSON;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.testdemo.common.ApiResult;
import com.example.testdemo.entity.TUser;
import com.example.testdemo.mapper.TUserMapper;
import com.example.testdemo.service.TUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author author
 * @since 2023-07-21
 */
@Slf4j
@RestController
@RequestMapping("/t-user")
public class TUserController {
    @Autowired
    private TUserService tUserService;

    @Autowired
    private TUserMapper tUserMapper;

    /**
     * 数据库查询返回MAP查询方式
     *
     * @return
     */
   @GetMapping("/test1/{id}")
      public ApiResult test1(@PathVariable("id") String id){
       List<TUser> stringObjectMap =tUserMapper.selectList1(id);
        JSONArray jsonArray = JSONUtil.parseArray(stringObjectMap);
       Map<String, String> stringObjectMap1 = tUserMapper.selectMapById(id);
        TUser tUser = tUserMapper.selectById(id);
       return ApiResult.success(stringObjectMap);
   }


    /**
     * 新增数据
     * @return
     */
    @GetMapping("/testInsert")
    public ApiResult testInsert(){
        TUser iUser = new TUser();
        String date1 = "20150718";
        SimpleDateFormat si = new SimpleDateFormat ("yyyyMMdd");
        try {
            Date parse = si.parse(date1);
//            LocalDate now1 = LocalDate.now();
            iUser.setBirth(parse);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        iUser.setEmail("123213");
        int a = tUserMapper.insert(iUser);
       return ApiResult.success(a);
    }

    /**
     * queryWrapper使用
     * 日志等级打印
     * @return
     */
    @GetMapping("/queryWrapper")
    public ApiResult test2(){
        QueryWrapper<TUser> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("id", "1");
        List<TUser> tUsers = tUserMapper.selectList(queryWrapper);
        String result = "Hello Spring Boot ! ";
        System.out.println(result);
        log.error("error log");
        log.warn("warn log");
        log.info("info log");
        log.debug("debug log");
        log.trace("trace log");
        return ApiResult.success(tUsers);
    }


    /**
     * list返回问题
     */
    @GetMapping("/list1")
    public ApiResult list1(){
        List<String> aa = new ArrayList<>();
        aa.add("11111");
        listAdd(aa);
        ApiResult<List<String>> success = ApiResult.success(aa);
        success.setCode("200");
        return success;
    };

    public void listAdd(List<String> aa) {
        System.out.println(aa);
        aa.add("333");
    }





}
