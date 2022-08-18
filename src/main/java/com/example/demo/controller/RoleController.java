package com.example.demo.controller;

import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/role")
public class RoleController {

    @Autowired
    public RoleService roleService;

    @PostMapping("/createRole")
    public Role createNewRole(@RequestBody Role role){
        return roleService.createNewRole(role);
    }

    @GetMapping("/showAllRole")
    public List<Role> hello(){
        return roleService.getRole();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUsers(@PathVariable("id") Long id){
//        System.out.println("the id sent by angualr is = "+id);
        roleService.deleteRole(id);
    }
}
