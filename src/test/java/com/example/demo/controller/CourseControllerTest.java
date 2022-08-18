package com.example.demo.controller;

import com.example.demo.domain.Course;
import com.example.demo.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseControllerTest {

    @Autowired
    CourseRepository courseRepository;

    @Test
    public void addCourse(){
        Course course=Course.builder()
                .name("PYTHON")
                .build();
        courseRepository.save(course);
    }
}