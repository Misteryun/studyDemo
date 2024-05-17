package com.example.testdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.testdemo.entity.TUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author author
 * @since 2023-07-21
 */
@Mapper
public interface TUserMapper extends BaseMapper<TUser> {

    List<TUser> selectList1(@Param("id")String id);

    /**
     * @Caption 根据id查询用户信息为map集合
     * @Param id
     * @Return map<字段名, 值>
     */
    Map<String, String> selectMapById(String id);

    List<TUser> findAll();
}
