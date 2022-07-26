package com.example.demo.service.impl;

import com.example.demo.constant.ERole;
import com.example.demo.domain.Comment;
import com.example.demo.domain.News;
import com.example.demo.domain.SubComment;
import com.example.demo.dto.NewsDTO;
import com.example.demo.exception.EventNotFoundException;
import com.example.demo.exception.NewsNotFoundException;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.NewsRepository;
import com.example.demo.repository.SubCommentRepository;
import com.example.demo.request.create.CreateCommentRequest;
import com.example.demo.request.create.CreateNewsRequest;
import com.example.demo.request.create.CreateSubCommentRequest;
import com.example.demo.request.update.UpdateNewsRequest;
import com.example.demo.response.NewsResponse;
import com.example.demo.response.NewsResponsePage;
import com.example.demo.service.JwtService;
import com.example.demo.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service @RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {
    private final MongoTemplate mongoTemplate;
    @Autowired
    private JwtService jwtService;

    @Autowired
    public NewsRepository newsRepository;

    @Autowired
    public CommentRepository commentRepository;

    @Autowired
    public SubCommentRepository subCommentRepository;

    @Override
    public News updateById(String id, UpdateNewsRequest request) {
        Optional<News> news = newsRepository.findById(id);
        if (news.isEmpty()) {
            throw new NewsNotFoundException("Can't find news with id = " + request.getId());
        }
        News updateEntity = news.get();
        NewsDTO.convertNewsRequestToNews1(request, updateEntity);

        return newsRepository.save(updateEntity);
    }

    @Override
    public News insert(CreateNewsRequest request) {
        return newsRepository.insert(NewsDTO.convertNewsRequestToNews(request));
    }

    @Override
    public List<News> findAll(Integer page, Integer pageSize) {
        return newsRepository.findAll(PageRequest.of(page, pageSize)).toList();
    }

    @Override
    public News findById(String id) {
        Optional<News> news = newsRepository.findById(id);
        if (news.isEmpty()) {
            throw new NewsNotFoundException("Can not find news with id = " + id);
        }
        return news.get();
    }

    @Override
    public NewsResponsePage findByHashTag(String hashTag, int page, int pageSize) {

        // page - Current page. E.g: 1, 2, 3
        // pageSize - The number of news on the page (20 items)
        Sort sort = Sort.by(Sort.Direction.DESC, "lastUpdatedDate");
        Pageable pageable = PageRequest.of(page, pageSize, sort);
        if (hashTag == null) {
            hashTag = "";
        }

        Page<News> newsPage = newsRepository.findByHashTagContaining(hashTag, pageable);

        // Convert list News -> list NewsResponse
        List<NewsResponse> contents = newsPage.getContent().stream()
                .map(item -> new NewsResponse(item.getTitle(), item.getContent(), item.getBanner(), item.getHashTag(), item.getCreatedDate(), item.getLastUpdatedDate(), item.getComments().size()))
                .collect(Collectors.toList());
        return NewsResponsePage.builder()
                .contents(contents)
                .pageNo(page)
                .pageSize(pageSize)
                .totalPages(newsPage.getTotalPages())
                .totalElements(newsPage.getTotalElements())
                .build();
    }

    @Override
    public void deleteNewsById(String id, String token) {
        String createUserIdCheck = jwtService.parseTokenToUserId(token);
        News news = newsRepository.findById(id).get();
        if (!createUserIdCheck.equals(news.getCreateUserId())) {
            throw new NewsNotFoundException("NewsId does not exist");
        }
        newsRepository.deleteById(id);
    }

    @Override
    public News addComment(String newsId, String token, CreateCommentRequest createCommentRequest) {
        News news = newsRepository.findById(newsId).get();
        if (news == null) {
            throw new NewsNotFoundException("NewsId does not exist");
        }
        String userId = jwtService.parseTokenToUserId(token);

        Comment comment = new Comment();
        comment.setUserId(userId);
        comment.setContent(createCommentRequest.getContent());
        comment.setCreatedDate(System.currentTimeMillis());
//        commentRepository.save(comment);
        news.getComments().add(comment);
        return newsRepository.save(news);
    }

    @Override
    public void deleteComment(String commentId, String token) {
        Comment comment = commentRepository.findById(commentId).get();
        if (comment == null) {
            throw new EventNotFoundException("NewsId does not exit");
        }
        String userId = jwtService.parseTokenToUserId(token);
        ERole eRole = ERole.valueOf(jwtService.parseTokenToRole(token));
        if ((!userId.equals(comment.getUserId())  || !(eRole.equals(ERole.ADMIN)))){
            throw new EventNotFoundException("Unauthorized to delete comment");
        }
        for (SubComment c : comment.getSubComment()) {
            subCommentRepository.deleteById(c.getId());
        }

        commentRepository.deleteById(commentId);
    }

    @Override
    public Long showCommentNumber(String newsId) {
        News news = newsRepository.findById(newsId).get();
        if (news == null) {
            throw new NewsNotFoundException("This newsId does not exist");
        }
        Long commentNumber = Long.valueOf(news.getComments().size());
        return commentNumber;
    }

    @Override
    public News addSubCommentToComment(String token, String commentId, CreateSubCommentRequest createSubCommentRequest) {
        News news = newsRepository.findById(createSubCommentRequest.getEntityId()).get();
        if (news == null){
            throw new NewsNotFoundException("NewsID does not exist");
        }
        Comment comment = commentRepository.findById(commentId).get();
        if (comment == null){
            throw new NewsNotFoundException("CommentID does not exist");
        }
        String userId = jwtService.parseTokenToUserId(token);
        SubComment subComment = new SubComment();
        subComment.setEntityId(createSubCommentRequest.getEntityId());
        subComment.setCommentId(commentId);
        subComment.setUserId(userId);
        subComment.setContent(createSubCommentRequest.getContent());
        subComment.setCreatedDate(System.currentTimeMillis());
        subCommentRepository.save(subComment);
        comment.getSubComment().add(subComment);
        return newsRepository.save(news);
    }

    @Override
    public void deleteSubComment(String token, String subCommentId) {
        SubComment subComment = subCommentRepository.findById(subCommentId).get();
        if (subComment == null ){
            throw new NewsNotFoundException("SubCommentId does not exist");
        }
        Comment comment = commentRepository.findById(subComment.getCommentId()).get();
        String userId = comment.getUserId();

        ERole role = ERole.valueOf(jwtService.parseTokenToRole(token));
        String userId1 = jwtService.parseTokenToUserId(token);
        String commentId = subComment.getCommentId();

        if (!(role.equals(ERole.ADMIN)) || !(subComment.getUserId().equals(userId1)) || !(userId.equals(commentId)) ) {
            throw new NewsNotFoundException("Unauthorized to delete Subcomment");
        }
        subCommentRepository.delete(subComment);
    }
}

