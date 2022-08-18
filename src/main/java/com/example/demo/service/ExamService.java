package com.example.demo.service;

import com.example.demo.domain.Exam;
import com.example.demo.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamService {

    @Autowired
    ExamRepository examRepository;
//    private final ExamRepository examRepository;
//
//    @Autowired
//    public ExamService(ExamRepository examRepository) {
//        this.examRepository = examRepository;
//    }

    public List<Exam> listShowExams(int courseId) {
        return examRepository.findAllByCourseId(courseId);
    }
    public List<Exam> getAllExams(){
        return examRepository.findAll();
    }

//    public String swagatam() {
//        return "hello";
//    }
}
