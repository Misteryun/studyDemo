package com.example.testdemo.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.testdemo.common.ApiResult;
import com.example.testdemo.entity.TUser;
import com.example.testdemo.mapper.TUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
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

    /**
     * 数据库查询返回MAP查询方式
     *
     * @return
     */
   @GetMapping("/test1")
      public ApiResult test1(){
       Map<String, Object> stringObjectMap =tUserMapper.selectList1();
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
     * @return
     */
    @GetMapping("/queryWrapper")
    public ApiResult test2(){
        QueryWrapper<TUser> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("id", "1");
        List<TUser> tUsers = tUserMapper.selectList(queryWrapper);
        return ApiResult.success(tUsers);
    }





}
