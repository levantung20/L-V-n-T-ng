package com.example.demo.repository;

import com.example.demo.domain.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventRepository extends MongoRepository<Event,String> {
    Event findByTitleLike(String title);
}
