package com.example.testdemo.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
/**
 * <p>
 *
 * </p>
 *
 * @author author
 * @since 2023-07-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("test")
@ApiModel(value="test对象", description="")
public class Test {

    private Integer id;

    private String revision;

}
