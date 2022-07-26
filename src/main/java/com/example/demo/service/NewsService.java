package com.example.demo.service;

import com.example.demo.domain.Comment;
import com.example.demo.domain.News;
import com.example.demo.request.create.CreateCommentRequest;
import com.example.demo.request.create.CreateSubCommentRequest;
import com.example.demo.request.update.UpdateNewsRequest;
import com.example.demo.request.create.CreateNewsRequest;
import com.example.demo.response.NewsResponsePage;

import java.util.List;

public interface NewsService {
    News updateById(String id, UpdateNewsRequest request);

    List<News> findAll(Integer page, Integer pageSize);

    News findById(String id);

    News insert(CreateNewsRequest request);

    NewsResponsePage findByHashTag(String hashTags, int page, int pageSize);

    void deleteNewsById(String id, String token);

    News addComment(String newsId, String token, CreateCommentRequest createCommentRequest);

    void deleteComment(String commentId, String token);

    Long showCommentNumber(String newsId);

    News addSubCommentToComment(String token, String commentId, CreateSubCommentRequest createSubCommentRequest);

    void deleteSubComment(String token, String subCommentId);
}

