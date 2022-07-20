package com.example.demo.repository;

import com.example.demo.domain.News;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface NewRepository extends MongoRepository<News, String> {

}
