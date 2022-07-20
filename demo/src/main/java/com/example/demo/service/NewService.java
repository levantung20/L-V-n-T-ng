package com.example.demo.service;

import com.example.demo.domain.News;
import com.example.demo.request.NewsRequest;

import java.util.List;
import java.util.Optional;

public interface NewService {
    News save(String token, NewsRequest newsRequest);

    List<News> findAll();

    Optional<News> findById(String id);
}
