package com.example.testdemo.controller;


import com.example.testdemo.common.ApiResult;
import com.example.testdemo.entity.TUser;
import com.example.testdemo.mapper.TUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
      public ApiResult test(){
       Map<String, Object> stringObjectMap =tUserMapper.selectList1();
       return ApiResult.success(stringObjectMap);
   }

}
