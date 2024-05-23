package com.example.testdemo;


import com.example.testdemo.entity.TUser;
import com.example.testdemo.service.Test1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@SpringBootTest
 class CommonlyUsed {

    @Autowired
    private Test1 test1;

    /**
     * 去掉字符串中的空格方法
     */
    @Test
    void  replaceSpace(){
        // 原始的 JSON 字符串
        String jsonString = "{\n" +
                "    \"passWord\": \"324324\",\n" +
                "    \"gender\": 222,\n" +
                "    \"birth\": \"2023-07-23T07:00:00\",\n" +
                "    \"testId\": 1,\n" +
                "    \"id\": 1,\n" +
                "    \"userName\": \"小李\",\n" +
                "    \"type\": 2,\n" +
                "    \"email\": \"666\"\n" +
                "}";

        // 去掉换行符
        String jsonStringWithoutNewlines = jsonString.replace("\n", "");

        // 输出去掉换行符后的 JSON 字符串
        System.out.println(jsonStringWithoutNewlines);
    };

    /**
     * AtomicInteger用于累加计算
     */
    @Test
    void atomicInteger() {
        // 创建 AtomicInteger 对象，并初始化为 0
        AtomicInteger qualityInspectionTotal = new AtomicInteger(0);

        // 增加指定的增量，并获取增加后的结果
        int result = qualityInspectionTotal.addAndGet(5);

        // 输出增加后的结果
        System.out.println("增加后的结果：" + result); // 输出：增加后的结果：5

        // 再次增加指定的增量，并获取增加后的结果
        result = qualityInspectionTotal.addAndGet(10);

        // 输出增加后的结果
        System.out.println("增加后的结果：" + result); // 输出：增加后的结果：15
    }

    /**
     * stream流常用用法
     */
    @Test
    void  joining(){
        //stream join用法
        Set<String> setList = new HashSet<>();
        setList.add("小李");
        setList.add("小天");
        setList.add("小地");
        String collect = setList.stream().collect(Collectors.joining(","));
        System.out.println(collect);

        List<TUser> list =  new ArrayList<>();
         list.add(new TUser(1,"2","4","4"));
        list.add(new TUser(1,"3","4","4"));
        list.add(new TUser(1,"2","4","4"));
        TUser tUser = new TUser();
        tUser.setBirth(new Date());
        System.out.println(tUser);

        // 获取所有的 businessId 并去重
        List<String> distinctBusinessIds = list.stream()
                .map(TUser::getUserName)
                .collect(Collectors.toList());

        // 输出去重后的 businessId 列表
        System.out.println("去重后的 businessId 列表：" + distinctBusinessIds);

    }


    @Test
    void test(){
        /**
         * java的链式调用
         */
        System.out.println(test1.test2().test3());
    }

}
