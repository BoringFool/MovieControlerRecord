package com.zm.service;

import java.util.List;

import com.zm.model.Course;

public interface CourseService {
    /**
     *  A 添加课程
     * @param course 要添加的课程信息
     * @return
     */
    int insert(Course course);

    /**
     * A删除课程
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id); 

    /**
     * A根据课程号查看课程详情
     * @param id 课程号 
     * @return
     */
    Course selectByPrimaryKey(Integer id);
	/**
	 * A查看所有课程
	 * @return 返回课程列表
	 */
	List<Course> getAllCourse();



}