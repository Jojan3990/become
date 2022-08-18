package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import liquibase.pro.packaged.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {//this will have all resources for API

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/showAllUser")
    public List<User> hello(){
        return userService.getUser();
    }

    @GetMapping("/userById/{id}")
    public User hello(@PathVariable("id") Long id) throws Exception {
        return userService.getByIdUser(id);
    }

    @PostMapping("/usersAdd")
    public User addUser(@RequestBody User user) {

//        return userService.addUser(user);
        System.out.println(user);
        return null;
    }

    @PutMapping("/usersUpdate")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUsers(@PathVariable("id") Long id){
//        System.out.println("the id sent by angualr is = "+id);
        userService.deleteUser(id);
    }

//    @GetMapping("/paginationEg")
//    public void paginationExample(){
//        userService.pageEg();
//    }
}
