package com.example.demo.service;

import com.example.demo.domain.News;

import com.example.demo.request.update.UpdateNewsRequest;
import com.example.demo.request.create.CreateNewsRequest;

import java.util.List;
import java.util.Optional;

public interface NewService {
    News save(String id, UpdateNewsRequest updateNewsRequest, String token);

    List<News> findAll(Integer paze, Integer pazeSize);

    Optional<News> findById(String id);

    News insert(CreateNewsRequest createNewsRequest, String token);

    List<News> findByHashTag(String hashTags, Integer page, Integer pageSize);

    void deleteNewsById(String id);


}
