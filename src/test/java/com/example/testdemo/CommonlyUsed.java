package com.example.testdemo;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
 class CommonlyUsed {

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
}
