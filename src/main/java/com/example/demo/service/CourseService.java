package com.example.demo.service;

import com.example.demo.domain.Course;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;


    public Course createNewCourse(Course course){return courseRepository.save(course);}
}
