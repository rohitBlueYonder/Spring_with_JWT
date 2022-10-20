package com.springboot.jwt.spring_with_jwt.controller;

import com.springboot.jwt.spring_with_jwt.model.User;
import com.springboot.jwt.spring_with_jwt.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/saveUser")
    public String savingUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("/getUserDetails/{userId}")
    public User getUserDetails(@PathVariable("userId") ObjectId id){
        return userService.getUser(id);
    }
}
