package com.example.demo.service;

import com.example.demo.domain.News;
import com.example.demo.request.CreateNewsRequest;
import com.example.demo.request.NewsRequest;
import com.example.demo.request.UpdateNewsRequest;

import java.util.List;
import java.util.Optional;

public interface NewService {
    News save(String id, UpdateNewsRequest updateNewsRequest, String token);
    List<News> findAll();

    Optional<News> findById(String id);

    News insert(CreateNewsRequest createNewsRequest, String token);

   void deleteNewsById(String id);
}
