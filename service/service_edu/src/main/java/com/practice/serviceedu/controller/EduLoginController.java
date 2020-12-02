package com.practice.serviceedu.controller;

import com.practice.commonutils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName 用户登录类
 * @Description TODO
 * @Author Administrator
 * @Date 2020/11/29 0029 22:54
 * @Version 1.0
 */
@RestController
@CrossOrigin
@RequestMapping("/eduservice/user")
@Api(value = "用户登录")
public class EduLoginController {

    @ApiOperation(value = "登录页面")
    @PostMapping("login")
    public R login(){
        return R.ok().data("token","admin");
    }

    @ApiOperation(value = "用户管理")
    @GetMapping("info")
    public R info(){
        return R.ok().data("name","admin").data("roles","[JiCuLin]").data("avatar","null");
    }


}
