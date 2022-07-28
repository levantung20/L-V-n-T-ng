package com.example.demo.service;

import com.example.demo.domain.Comment;
import com.example.demo.domain.News;
import com.example.demo.request.create.CreateCommentRequest;
import com.example.demo.request.create.CreateNewsRequest;
import com.example.demo.request.create.CreateSubCommentRequest;
import com.example.demo.request.update.UpdateNewsRequest;
import com.example.demo.response.CommentResponse;
import com.example.demo.response.NewSearchResponse;
import com.example.demo.response.NewsResponse;

import java.util.List;

public interface NewsService {
    News updateById(String id, UpdateNewsRequest request);

    List<News> findAll(Integer page, Integer pageSize);

    News findById(String id);

    News insert(String token, CreateNewsRequest request);

    NewSearchResponse findByHashTag(String hashTags, int page, int pageSize);

    NewsResponse getNewsDetailById(String newsId);

    void deleteNewsById(String id, String token);

    News addComment(String newsId, String token, CreateCommentRequest createCommentRequest);

    void deleteComment(String commentId, String token);

    Long showCommentNumber(String newsId);

    Comment addSubCommentToComment(String token, String commentId, CreateSubCommentRequest createSubCommentRequest);

    void deleteSubComment(String token, String subCommentId);

    List<CommentResponse> getListComment(String newsId, int page, int pageSize);


}

