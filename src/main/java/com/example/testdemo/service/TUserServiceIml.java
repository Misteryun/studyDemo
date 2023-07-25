package com.example.testdemo.service;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.testdemo.entity.TUser;
import com.example.testdemo.mapper.TUserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TUserServiceIml  extends ServiceImpl<TUserMapper, TUser>  implements TUserService  {

}
