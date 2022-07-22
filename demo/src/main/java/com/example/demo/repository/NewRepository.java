package com.example.demo.repository;

import com.example.demo.domain.News;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Repository
public interface NewRepository extends MongoRepository<News, String> {
    List<News> findByHashTags(String hashTags);

}
