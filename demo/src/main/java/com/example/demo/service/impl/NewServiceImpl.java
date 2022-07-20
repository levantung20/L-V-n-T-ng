package com.example.demo.service.impl;

import com.example.demo.domain.News;
import com.example.demo.repository.NewRepository;
import com.example.demo.request.NewsRequest;
import com.example.demo.service.JwtService;
import com.example.demo.service.NewService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NewServiceImpl implements NewService {

    @Autowired
    private JwtService jwtService;

    public final NewRepository newRepository;

    @Override
    public News save(String token, NewsRequest newsRequest) {
        String userId = jwtService.parseTokenToUserId(token);
        System.out.println(userId);
        News news1 = new News();
        news1.setUserId(userId);
        news1.setTitle(newsRequest.getTitle());
        news1.setContent(newsRequest.getContent());
        news1.setLastUpdateTime(new Date().getTime());
        news1.setComments(newsRequest.getComments());
        news1.setHashTags(newsRequest.getHashTags());
        return newRepository.save(news1);
    }

    @Override
    public List<News> findAll() {
        return newRepository.findAll();
    }

    @Override
    public Optional<News> findById(String id) {
        return newRepository.findById(id);
    }
}
