package com.example.testdemo;

import com.example.testdemo.entity.TUser;
import com.example.testdemo.mapper.TUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class TesTdemoApplicationTests {

    @Autowired
    private TUserMapper iUserMapper;

    @Test
    void contextLoads() {
        TUser iUser = new TUser();
        String date1 = "20150718";
        SimpleDateFormat si = new SimpleDateFormat ("yyyyMMdd");
        try {
          Date parse = si.parse(date1);
            iUser.setBirth(parse);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        iUser.setEmail("123213");
        iUserMapper.insert(iUser);
    }

}
