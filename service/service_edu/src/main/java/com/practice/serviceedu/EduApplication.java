package com.practice.serviceedu;

import  org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName EduApplication
 * @Description TODO
 * @Author Administrator
 * @Date 2020/11/10 0010 23:50
 * @Version 1.0
 */
@SpringBootApplication
@ComponentScan(value = "com.practice")
public class EduApplication {

    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class,args);
    }

}
