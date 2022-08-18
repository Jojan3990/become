package com.example.demo.service;

import com.example.demo.domain.Question;
import com.example.demo.repository.QuestionRepository;
import liquibase.pro.packaged.Q;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    public Question createNewQuestion(Question question){
        return questionRepository.save(question);
    }

    public List<Question> getAllQuestions(){
        return questionRepository.findAll();
    }
}
