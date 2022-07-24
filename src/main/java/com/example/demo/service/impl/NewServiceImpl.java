package com.example.demo.service.impl;

import com.example.demo.constant.ERole;
import com.example.demo.domain.News;
import com.example.demo.dto.NewsDTO;
import com.example.demo.exception.NewsNotFoundException;
import com.example.demo.exception.UserTypeNotAllow;
import com.example.demo.repository.NewRepository;
import com.example.demo.request.create.CreateNewsRequest;
import com.example.demo.request.update.UpdateNewsRequest;
import com.example.demo.service.JwtService;
import com.example.demo.service.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NewServiceImpl implements NewService {

    @Autowired
    private JwtService jwtService;

    @Autowired
    public NewRepository newRepository;

    @Override
    public News save(String id, UpdateNewsRequest updateNewsRequest, String token) {
        Optional<News> news = newRepository.findById(id);
        if (news.isEmpty()) {
            throw new NewsNotFoundException("Can't find news with id = " + updateNewsRequest.getId());
        }
        ERole eRole = ERole.valueOf(jwtService.parseTokenToRole(token));
        if (!eRole.equals(ERole.ADMIN)) {
            throw new UserTypeNotAllow("can't not update news with role equal user");
        }
        String updateBy = jwtService.parseTokenToUserId(token);
        News news1 = news.get();
        NewsDTO.convertNewsRequestToNews1(updateNewsRequest, news1);
        news1.setUpdateUserId(updateBy);
        return newRepository.save(news1);
    }


    @Override
    public News insert(CreateNewsRequest createNewsRequest, String token) {
        String role = jwtService.parseTokenToRole(token);
        if (!role.equals(ERole.ADMIN.name())) {
            throw new UserTypeNotAllow("can't create news with role = " + role);
        }
        return newRepository.insert(NewsDTO.convertNewsRequestToNews(createNewsRequest, token));
    }

    @Override
    public List<News> findAll(Integer page, Integer pageSize) {
        return newRepository.findAll(PageRequest.of(page, pageSize)).toList();
    }

    @Override
    public News findById(String id) {
        Optional<News> news = newRepository.findById(id);
        if (news.isEmpty()) {
            throw new com.example.demo.exception.NewsNotFoundException("Can not find news with id = " + id);
        }
        return news.get();
    }

    @Override
    public List<News> findByHashTag(String hashTags, Integer page, Integer pageSize) {
        List<News> news = newRepository.findByHashTags(hashTags).stream().skip((page - 1) * pageSize).limit(pageSize).collect(Collectors.toList());
        if (news.isEmpty()) {
            throw new com.example.demo.exception.NewsNotFoundException("Can not find news with hashTag = " + hashTags);
        }
        return news;
    }

    @Override
    public void deleteNewsById(String id) {
        News deleteNews = findById(id);
        newRepository.deleteById(id);
    }

}
