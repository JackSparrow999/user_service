package com.ykn.user_service.controllers;

import com.ykn.user_service.dtos.user.UserRequest;
import com.ykn.user_service.dtos.user.UserResponse;
import com.ykn.user_service.entities.user.User;
import com.ykn.user_service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public UserResponse saveUser(@RequestBody UserRequest userRequest){
        return userService.saveUser(userRequest);
    }

    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/get")
    public User getUserById(@RequestParam Long id){
        return userService.getUserById(id);
    }
}
