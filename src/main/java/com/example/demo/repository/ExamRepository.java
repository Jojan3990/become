package com.example.demo.repository;


import com.example.demo.domain.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ExamRepository extends JpaRepository<Exam,Integer> {
    List<Exam> findAllByCourseId(Integer courseId);
    List<Exam> findAll();
    Optional<Exam> findById(Integer id);//this shows that there may not be value instead of null

    //this is another way of creating query
//    @Query("select * from Exam")
//    Exam retrieveByName(@Param("name") String name);
//    String showGreetings();
}
