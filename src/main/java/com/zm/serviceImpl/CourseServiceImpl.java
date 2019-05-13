package com.zm.serviceImpl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.zm.dao.CourseDao;
import com.zm.model.Course;
import com.zm.service.CourseService;
@Service
public class CourseServiceImpl implements CourseService {

    @Resource
    private CourseDao courseDao;

    public int insert(Course course) {
        return courseDao.insert(course);
    }

    public int deleteByPrimaryKey(Integer id) {
        return courseDao.deleteByPrimaryKey(id);
    }

    public List<Course> getAllCourse() {
        return courseDao.getAllCourse();
    }

    public Course selectByPrimaryKey(Integer id) {
        return courseDao.selectByPrimaryKey(id);
    }

}
