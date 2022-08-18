package com.example.demo.controller;

import com.example.demo.domain.Question;
import com.example.demo.repository.QuestionRepository;
import com.example.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestionController {
    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    QuestionService questionService;

//    @GetMapping(value = {"","/"})
//    public List<Question> getQuestions(){return questionService.getAllQuestions();}

    @PostMapping("/createQuestion")
    public Question createQuestion(@RequestBody Question question){
        return questionService.createNewQuestion(question);
    }

}
