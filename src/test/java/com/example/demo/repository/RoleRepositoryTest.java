package com.example.demo.repository;

import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RoleRepositoryTest {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void addRole(){
//        User user= User.builder()
//                .email("rai@gmail.com")
//                .name("jojan")
//                .password("1234")
//                .username("jojan2443")
//                .build();
        Role role=Role.builder()
                .name("student")
//                .users(user)
                .build();
        roleRepository.save(role);
    }
}