package com.example.demo.controller;

import com.example.demo.domain.Exam;
import com.example.demo.repository.ExamRepository;
import com.example.demo.service.ExamService;
import liquibase.pro.packaged.I;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/exams")
public class ExamController {

//    @Autowired
//    ExamService examService;
//    @Autowired
//    ExamRepository examRepository;
    private final ExamService examService;

    @Autowired
    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    //note @PathVariable is used to extract value from URL.(where url contains some value)
    @GetMapping(path = "/{courseValue}") //{} here we send some value
    public List<Exam> getExamByCourse(@PathVariable("courseValue") Integer courseValue){//courseValue is value we take from parameter
        return examService.listShowExams(courseValue);
    }

    @GetMapping(path = {"/getAllExams"})
    public List<Exam> getAllExams(){
        return examService.getAllExams();
    }

    @GetMapping(path = "/listDemo") //testing learn List
    public void listDemo() {
        List<Exam> exams =new ArrayList<>();
        exams.add(new Exam("Jojan"));
        for(Exam exam:exams){
            System.out.println(exam.getName());
        }
    }

    @GetMapping(path = "/optionalDemo") //testing learn List
    public void showOptionalDemo() {
//        String[] words=new String[10];
//        Optional<String> checkNull=Optional.ofNullable(words[5]);
//        String word = words[5].toLowerCase();
//        System.out.print(word);

        Integer val1=null;
        Integer val2=new Integer(10);
        Optional<Integer> checkNull=Optional.ofNullable(val1); // //Optional.ofNullable - allows passed parameter to be null.
        Optional<Integer> checkNull1=Optional.of(val2); //      //Optional.of - throws NullPointerException if passed parameter is null
        System.out.println("First is = "+checkNull.isPresent()); //      //Optional.isPresent - checks the value is present or not
        System.out.println("Second is = "+checkNull1.isPresent());

//        System.out.println("First Get is is = "+checkNull.get()); //this generated error
        System.out.println("Second Get is = "+checkNull1.get());

        //Optional.orElse - returns the value if present otherwise returns
        //the default value passed.
        val1=checkNull.orElse(new Integer(10)); //this is will set null val1 as 10

        System.out.println(val1);
    }
    }

