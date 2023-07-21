package com.example.testdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.testdemo.entity.TUser;

import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author author
 * @since 2023-07-21
 */
public interface TUserMapper extends BaseMapper<TUser> {

    Map<String,Object> selectList1();

}
