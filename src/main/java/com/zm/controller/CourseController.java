package com.zm.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zm.model.Course;
import com.zm.service.CourseService;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Resource(name="courseService")
    private CourseService courseService;

    /**
     *A 查看所有课程
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/list") 
    public ModelAndView getAllCourse(HttpServletRequest request,Model model) {
        ModelAndView mav = new ModelAndView("course-list"); 
         List<Course> courses = courseService.getAllCourse(); 
         System.out.println(courses);
         for(Course cou:courses){
             System.out.println(cou.getCname());
         }
         mav.addObject("courses", courses); 
        return mav;  
    }

    /**
     * A查看课程详情
     * @param request
     * @param model
     * @param id 课程id
     * @return
     */
    @RequestMapping("/detail") 
    public ModelAndView getCourseDetail(HttpServletRequest request,Model model,Integer id) {
        ModelAndView mav = new ModelAndView("course-detail"); 
         Course course = courseService.selectByPrimaryKey(id); 
         System.out.println(course);
         mav.addObject("course", course); 
        return mav;  
    }

    /**
     * A添加课程
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/add") 
    public ModelAndView addCourse(HttpServletRequest request,Model model) {
        ModelAndView mav = new ModelAndView("course-edit"); 
        return mav;  
    }

    /**
     * A 保存课程
     * @param course 课程信息
     * @return
     */
    @RequestMapping("/save") 
    public ModelAndView saveCourse(Course course) {
        ModelAndView mav = new ModelAndView("course-list"); 
        courseService.insert(course);
        List<Course> courses = courseService.getAllCourse(); 
        mav.addObject("courses", courses); 
        return mav;  
    }

    /**
     * A删除课程
     * @param id 课程id
     * @return
     */
    @RequestMapping("/delete") 
    public ModelAndView deleteCourse(Integer id) {
        courseService.deleteByPrimaryKey(id);
        ModelAndView mav = new ModelAndView("course-list"); 
        List<Course> courses = courseService.getAllCourse(); 
        mav.addObject("courses", courses); 
        return mav;  
    }

}
