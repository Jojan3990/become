package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    @Id
    @GeneratedValue//why only generated value?

    private Long id;
    @Column(nullable = false)
    private String question;

    //it is required here to create exam to create question
    @ManyToMany(mappedBy = "questions")//here Role id PK is referring to FK of user_id table i.e:- rold_id
    private Set<Exam> exams;
}
