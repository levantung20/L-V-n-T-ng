package com.example.demo.repository;

import com.example.demo.domain.*;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User,Long> {
    Optional<User> findByEmail(String email);

}
