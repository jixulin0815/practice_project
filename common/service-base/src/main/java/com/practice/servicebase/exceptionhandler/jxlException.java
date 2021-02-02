package com.practice.servicebase.exceptionhandler;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName jxlException
 * @Description TODO
 * @Author 自定义异常
 * @Date 2020/11/21 0021 21:49
 * @Version 1.0
 */
@Data
/**
 * 生成有参构造
 */
@AllArgsConstructor
/**
 * 生成无参构造
 */
@NoArgsConstructor
public class jxlException extends RuntimeException {

    @ApiModelProperty(value = "状态码")
    private Integer code;

    private String msg;

}

