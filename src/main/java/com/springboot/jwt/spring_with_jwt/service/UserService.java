package com.springboot.jwt.spring_with_jwt.service;

import com.springboot.jwt.spring_with_jwt.model.User;
import com.springboot.jwt.spring_with_jwt.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class UserService {


    private UserRepository userRepository;
    private TokenService tokenService;


    @Autowired
    public UserService(UserRepository userRepository, TokenService tokenService) {
        this.userRepository = userRepository;
        this.tokenService = tokenService;
    }

    public User getUser(ObjectId userId)
    {
        Optional<User> optionalUser = userRepository.findById(userId);
        return  optionalUser.orElseGet(optionalUser::get);
    }

    public String saveUser(User user){
        User savedUser = userRepository.save(user);
        String required_output = "Message: Successfully Created User" +
                "\nToken String: " + tokenService.createToken(savedUser.getId()) +
                "\n User Data: "+ savedUser;
        return required_output;
    }


}
