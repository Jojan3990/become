package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service //this is a bean more acts like bean
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User addUser(User user){
//        return userRepository.save(user);
        System.out.println(user);
        return null;
    }

    public List<User> getUser(){
        return  userRepository.findAll();
    }

    public User getByIdUser(Long id) throws Exception{
            if(userRepository.existsById(id)){
                return userRepository.findById(id).get();
            }
            else{
                throw new Exception("id not found");
            }
    }

    public User updateUser(User user){return userRepository.save(user);}

    public void deleteUser(Long userId){userRepository.deleteById(userId);}
}
