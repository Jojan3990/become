package com.example.demo.controller;

import com.example.demo.domain.Course;
import com.example.demo.repository.CourseRepository;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController{

    @Autowired //i dont need to focues on object creating just logic
    CourseRepository courseRepository;

    @Autowired
    CourseService courseService;

    @GetMapping({"/",""})
    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    @PostMapping("/createNewCourse")
    public Course createNewCourse(@RequestBody Course course){return courseService.createNewCourse(course);}
}
