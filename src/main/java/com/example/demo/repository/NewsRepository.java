package com.example.demo.repository;
import com.example.demo.domain.News;
import com.example.demo.response.NewsResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface NewsRepository extends MongoRepository<News, String> {

    List<News> findByHashTagLike(String hashTag);
}
