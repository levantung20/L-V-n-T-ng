package com.example.demo.service.impl;

import com.example.demo.domain.News;
import com.example.demo.domain.exception.NewsNotFoundException;
import com.example.demo.repository.NewRepository;
import com.example.demo.request.create.CreateNewsRequest;
import com.example.demo.service.JwtService;
import com.example.demo.service.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NewServiceImpl implements NewService {

    @Autowired
    private JwtService jwtService;

    @Autowired
    public  NewRepository newRepository;

    @Override
    public News save(String token, CreateNewsRequest createNewsRequest) {
        String userId = jwtService.parseTokenToUserId(token);
        System.out.println(userId);
        News news1 = new News();
        news1.setCreatedDate(new Date().getTime());
        news1.setCreatedBy(userId);
        news1.setTitle(createNewsRequest.getTitle());
        news1.setContent(createNewsRequest.getContent());
        news1.setComments(createNewsRequest.getComments());
        news1.setHashTags(createNewsRequest.getHashTags());
        return newRepository.save(news1);
    }

    @Override
    public List<News> findAll(Integer page, Integer pageSize) {
        return newRepository.findAll(PageRequest.of(page, pageSize)).toList();
    }

    @Override
    public Optional<News> findById(String id) {
        Optional<News> news = newRepository.findById(id);
        if (news.isEmpty()) {
            throw new NewsNotFoundException("Can not find news with id = " + id);
        }
        return news;
    }

    @Override
    public List<News> findByHashTags(String hashTag, Integer page, Integer pageSize) {
        List<News> news = newRepository.findByHashTags(hashTag).stream()
                .skip((page - 1) * pageSize)
                .limit(pageSize)
                .collect(Collectors.toList());
        if (news.isEmpty()) {
            throw new NewsNotFoundException("Can not find news with hashTag = " + hashTag);
        }
        return news;
    }
}
