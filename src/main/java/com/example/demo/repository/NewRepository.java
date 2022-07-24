package com.example.demo.repository;
import com.example.demo.domain.News;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface NewRepository extends MongoRepository<News, String> {
    List<News> findByHashTags(String hashTags);
}
