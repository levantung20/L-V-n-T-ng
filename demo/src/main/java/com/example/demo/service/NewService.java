package com.example.demo.service;

import com.example.demo.domain.News;

import com.example.demo.request.create.CreateNewsRequest;

import java.util.List;
import java.util.Optional;

public interface NewService {
    News save(String token, CreateNewsRequest createNewsRequest);

    List<News> findAll();

    Optional<News> findById(String id);

    List<News> findByHashTag(String hashTag);


}
