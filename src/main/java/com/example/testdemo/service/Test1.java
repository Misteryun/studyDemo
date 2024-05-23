package com.example.testdemo.service;

import org.springframework.stereotype.Service;

@Service
public class Test1 {

    public Test1 test2(){
        return this;
    }

   public int  test3(){
        System.out.println("woshihhhh");
        return 12;
    }
}
