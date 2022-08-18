package com.example.demo.service;

import com.example.demo.controller.RoleController;
import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import com.example.demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role createNewRole(Role role){
        return roleRepository.save(role);
    }
    public List<Role> getRole(){
        return  roleRepository.findAll();
    }
    public void deleteRole(Long userId){roleRepository.deleteById(userId);}


//    public void create_NewRole(Role role){
//        roleRepository.save(role);
//    }
}
