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

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(ObjectId userId){
        Optional<User> result = userRepository.findOne(new Example<User>() {
            @Override
            public User getProbe() {
                return null;
            }

            @Override
            public ExampleMatcher getMatcher() {
                return null;
            }
        });
        return result.get();
    }

    public String saveUser(User user){
        userRepository.save(user);
        return "User created successfully";
    }


}
