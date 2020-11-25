package com.practice.serviceedu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.practice.serviceedu.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.practice.serviceedu.entity.vo.TeacherQuery;

/**
 * <p>
 * 讲师 服务类
 * </p>
 * @author jxl
 * @since 2020-11-10
 */
public interface EduTeacherService extends IService<EduTeacher> {

    void pageQuery(Page<EduTeacher> pageParam, TeacherQuery teacherQuery);

}
