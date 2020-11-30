package com.practice.serviceedu.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.practice.commonutils.R;
import com.practice.serviceedu.entity.EduTeacher;
import com.practice.serviceedu.entity.vo.TeacherQuery;
import com.practice.serviceedu.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author jxl
 * @since 2020-11-10
 */
@RestController
@RequestMapping("/service/edu-teacher")
@CrossOrigin //跨域
@Api(value = "讲师管理")
public class EduTeacherController {

    /**
     * 注入service
     */
    @Autowired
    private EduTeacherService TeacherService;

    /**
     * 查询所有讲师数据
     */
    @ApiOperation(value = "所有讲师列表")
    @GetMapping("findAll")
    public R findAllTeacher(){
        List<EduTeacher> list = TeacherService.list(null);
        return R.ok().data("items",list);
    }

    /**
     * 根据id逻辑删除
     */
    @ApiOperation(value = "根据ID删除讲师")
    @DeleteMapping(value = "{id}")
    public R removeById(
            @ApiParam(name = "id", value = "讲师ID", required = true)
            @PathVariable String id){
        boolean flag = TeacherService.removeById(id);
        if (flag){
            return R.ok();
        }else {
            return R.error();
        }
    }
    /**
     * 分页插件
     */
    @ApiOperation(value = "分页讲师列表")
    @PostMapping("{page}/{limit}")
    public R pageQuery(
            @ApiParam(name = "page",value = "当前页码",required = true)
            @PathVariable Long page,
            @ApiParam(name = "limit",value = "每页记录数",required = true)
            @PathVariable Long limit,
            @ApiParam(name = "teacherQuery",value = "查询对象",required = false)
            @RequestBody TeacherQuery teacherQuery){
        Page<EduTeacher> pageParam = new Page<>(page,limit);
        TeacherService.pageQuery(pageParam,teacherQuery);
        List<EduTeacher> recodes = pageParam.getRecords();
        long total = pageParam.getTotal();
        /*try{
            int a = 10/0;
        }catch (Exception e){
            throw new jxlException(20001,"执行自定义异常");
        }*/

        /*Map map = new HashMap(16);
        map.put("total",toral);
        map.put("rows",recodes);
        return R.ok().data(map);*/
        return R.ok().data("total",total).data("recode",recodes);
    }
    /**
     * 讲师新增
     */
    @ApiOperation(value = "新增讲师")
    @PostMapping
    public R save(
            @ApiParam(name = "teacher",value = "讲师对象",required  = true)
            @RequestBody EduTeacher eduTeacher ){
        TeacherService.save(eduTeacher);
        return R.ok();
    }

    /**
     * 根据ID查询
     */
    @ApiOperation(value = "根据ID查询讲师")
    @GetMapping("{id}")
    public R getById(
            @ApiParam(name = "id",value = "讲师ID",required  = true)
            @RequestBody String id ){
        EduTeacher eduTeacher = TeacherService.getById(id);
        return R.ok().data("item",eduTeacher);
    }
    /**
     * 根据id修改
     */
    @ApiOperation(value = "根据ID修改讲师")
    @PutMapping("{id}")
    public R updateById(
            @ApiParam(name = "id", value = "讲师ID", required = true)
            @PathVariable String id,
            @ApiParam(name = "teacher", value = "讲师对象", required = true)
            @RequestBody EduTeacher eduTeacher){
        eduTeacher.setId(id);
        TeacherService.updateById(eduTeacher);
        return R.ok();
    }

}

