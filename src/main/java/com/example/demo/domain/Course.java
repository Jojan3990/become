package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @JsonBackReference// is a backreference that omits during the serialization process
    @OneToMany(mappedBy = "course")
    private Set<Exam> exams;



//    Serialization is the process of converting an object into a stream of bytes to store the object or
//    transmit it to memory, a database, or a file. Its main purpose is to save the state of an object in order to be able to recreate
//    it when needed.
}
