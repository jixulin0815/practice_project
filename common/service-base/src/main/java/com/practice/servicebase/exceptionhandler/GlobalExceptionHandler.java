package com.practice.servicebase.exceptionhandler;

import com.practice.commonutils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName 统一异常处理类
 * @Description TODO
 * @Author Administrator
 * @Date 2020/11/20 0020 15:17
 * @Version 1.0
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 统一异常处理类
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R  error(Exception e){
        e.printStackTrace();
        log.error(e.getMessage());
        return R.error().message("执行全局异常");
    }

    /**
     * 处理特定异常
     */
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public R error(ArithmeticException e){
        e.printStackTrace();
        log.error(e.getMessage());
        return R.error().message("执行了自定义异常");
    }

    /**
     * 自定义异常
     */
    @ExceptionHandler(jxlException.class)
    @ResponseBody
    public R error(jxlException e){
        e.printStackTrace();
        log.error(e.getMessage());
        return R.error().message(e.getMsg()).code(e.getCode());
    }


}
