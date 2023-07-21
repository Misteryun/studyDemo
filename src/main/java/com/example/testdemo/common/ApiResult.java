package com.example.testdemo.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@NoArgsConstructor(force = true)
@ApiModel(description = "统一返回报文封装")
public class ApiResult<T> {


    private static final String RET_MSG_SUCCESS = "SUCCESS";

    /**
     * 返回码： <br/>
     * 0 为正常范围，其他编码为错误
     */
    private String code ;

    private String message;

    private T data;


    public static <T> ApiResult<T> success(T rowData) {
        return ApiResult.<T>builder()
                .code(ResCode.success.getResCode())
                .message(RET_MSG_SUCCESS)
                .data(rowData)
                .build();
    }

    public static <T> ApiResult<T> success() {
        return ApiResult.<T>builder()
                .code(ResCode.success.getResCode())
                .message(RET_MSG_SUCCESS)
                .build();
    }

    public static  <T> ApiResult<T> fail(String code, String message) {
        return ApiResult.<T>builder()
                .code(code)
                .message(message)
                .build();
    }

    public static  <T> ApiResult<T> actionFail(String actionFailCode, String message) {
        return ApiResult.<T>builder()
                .code(actionFailCode)
                .message(message)
                .build();
    }

    public static <T> ApiResult<T> fail(Exception e) {
        return ApiResult.<T>builder()
                .code(ResCode.fail.getResCode())
                .message(e.getMessage())
                .build();
    }
}
