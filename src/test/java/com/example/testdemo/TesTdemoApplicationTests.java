package com.example.testdemo;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.testdemo.entity.TUser;
import com.example.testdemo.mapper.TUserMapper;
import com.example.testdemo.service.TUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import testpo.ProcessVO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class TesTdemoApplicationTests {

    @Autowired
    private TUserService tUserService;

    @Autowired
    private TUserMapper tUserMapper;


    /**
     * 序列化对象
     */
    @Test
    void contextLoads() {
         List<TUser> list = tUserService.list();
         String s = JSON.toJSONString(list);
         System.out.println(s);
    }

    /**
     * 序列化对象
     */
    @Test
    void lambdaQuery(){
        //mapper层封装的CRUD
        QueryWrapper<TUser> queryWrapper = new QueryWrapper<>();
        List<TUser> tUsers = tUserMapper.selectList(queryWrapper);
        //service层封装的CRUD
        List<TUser> list1 = tUserService.lambdaQuery().eq(TUser::getEmail,"7777").list();
        System.out.println(list1);
    }


    @Test
    void test(){
        List<String> userList = new ArrayList<>();
        List<String> userList1 = new ArrayList<>();

        // 获取提前启动工序
        List<String> processIds = Arrays.asList("4ffee2b2d73911ec9f9e0242ac100002",
                "54f39816d73911ec9f9e0242ac100002",
                "5c491171d73a11ec9f9e0242ac100002",
                "61dcdbd4d73911ec9f9e0242ac100002",
                "6249e76dd73a11ec9f9e0242ac100002",
                "707c2b16d73a11ec9f9e0242ac100002",
                "7795ce1acf6c11edbb0c0242ac1f0004",
                "2baa623ccf6d11edbb0c0242ac1f0004",
                "b9eb8dfbcf6d11edbb0c0242ac1f0004",
                "196677a6cf6e11edbb0c0242ac1f0004",
                "710182fecf6e11edbb0c0242ac1f0004",
                "d8f339e2cf6e11edbb0c0242ac1f0004");
        List<ProcessVO> processVOs =  new ArrayList<>();
        processIds.forEach(e ->
                {
                    ProcessVO vo = new ProcessVO();
                    vo.setAssignee(e);
                    processVOs.add(vo);
                }
                );
        System.out.println(JSON.toJSONString(processVOs));
        if (CollectionUtil.isNotEmpty(processVOs)) {
            // 逗号拼接而成 解析为username列表
            processVOs.forEach(item -> {
                if (StrUtil.isNotEmpty(item.getAssignee())) {
                    userList.addAll(Arrays.asList(item.getAssignee().split(",")));
                    userList1.addAll(Arrays.asList(item.getAssignee()));
                }
            });
            System.out.println(userList);
            System.out.println(userList1);
        }
    }



}
