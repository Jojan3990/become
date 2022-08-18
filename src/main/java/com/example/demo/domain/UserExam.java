package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class UserExam {

    @Id
    private int id;

    @ManyToOne //user can give multiple exams
    @JoinColumn(name="user_id",referencedColumnName = "id")
    private User userId;

    @ManyToOne
    @JoinColumn(name = "exam_id",referencedColumnName = "id")
    private Exam examId;

    private Date completedDate;
//    private int display_order;
}
