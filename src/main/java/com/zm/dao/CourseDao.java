package com.zm.dao;

import java.util.List;

import com.zm.model.Course;

public interface CourseDao {
	int deleteByPrimaryKey(Integer id);

	int insert(Course record);

	int insertSelective(Course record);

	Course selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Course record);

	int updateByPrimaryKey(Course record);

	List<Course> getAllCourse(); 

}

