package com.example.demo.repository;

import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void addUser(){
//        Role role=Role.builder()
//                .name("admin")
//                .build();
        for(int i=0;i<5;i++){
            User user=User.builder()
                    .email(i+"addhreld@gmail.com")
                    .name(i+"ddpeshfdfdn")
                    .password("1234")
                    .username("aminl2443dd")
//                .roles(role)
                    .build();
            userRepository.save(user);
        }
    }

    @Test
    public void pageEg(){
        PageRequest firstPageWithTwoElements = PageRequest.of(1, 4);
//        Page<User> allUser=userRepository.findAll(firstPageWithTwoElements);
        Long totalElements=userRepository.findAll(firstPageWithTwoElements).getTotalElements();
        long totalPages=userRepository.findAll(firstPageWithTwoElements).getTotalPages();
        List<User> users=userRepository.findAll(firstPageWithTwoElements).getContent();
        System.out.println("total Elements = "+totalElements);
        System.out.println("totalPages = " + totalPages);
        System.out.println("users = " + users);
    }

    @Test
    public void pageEgTwo(){
        PageRequest secondPageWithTwoElements = PageRequest.of(0, 2);
//        Page<User> allUser=userRepository.findAll(firstPageWithTwoElements);
        Long totalElements=userRepository.findAll(secondPageWithTwoElements).getTotalElements();
        long totalPages=userRepository.findAll(secondPageWithTwoElements).getTotalPages();
        List<User> users=userRepository.findAll(secondPageWithTwoElements).getContent();
        System.out.println("total Elements = "+totalElements);
        System.out.println("totalPages = " + totalPages);
        System.out.println("users = " + users);
    }

    @Test
    public void pageSortTest(){
//        PageRequest firstPageWithTwoElements = PageRequest.of(0, 4, Sort.by("name"));
//        PageRequest firstPageWithTwoElements = PageRequest.of(0, 4, Sort.by("name").descending());
        PageRequest firstPageWithTwoElements = PageRequest.of(0, 4, Sort.by("id").descending().and(Sort.by("name")));
        List<User> users=userRepository.findAll(firstPageWithTwoElements).getContent();
        System.out.println("users = " + users);
    }
}