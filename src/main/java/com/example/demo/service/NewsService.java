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
    public NewsResponse insert(String token, CreateNewsRequest request);
    public NewsResponse save(String id, UpdateNewsRequest request);

    public News findById(String id);

    public NewSearchResponse findByHashTag(String hashTags, int page, int pageSize);

    public NewsResponse getNewsDetailById(String newsId);

    public void deleteNewsById(String id, String token);

    public News addComment(String newsId, String token, CreateCommentRequest createCommentRequest);

    public void deleteComment(String commentId, String token);

    public Comment addSubCommentToComment(String token, String commentId, CreateSubCommentRequest createSubCommentRequest);

    public void deleteSubComment(String token, String subCommentId);

    public List<CommentResponse> getListComment(String newsId, int page, int pageSize);


}

