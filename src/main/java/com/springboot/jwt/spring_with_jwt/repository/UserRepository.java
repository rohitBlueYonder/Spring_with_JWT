package com.springboot.jwt.spring_with_jwt.repository;

import com.springboot.jwt.spring_with_jwt.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {
}
