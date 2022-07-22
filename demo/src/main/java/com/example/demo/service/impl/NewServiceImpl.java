package com.example.demo.service.impl;

import com.example.demo.constant.ERole;
import com.example.demo.domain.News;
import com.example.demo.exception.NewsNotFoundException;
import com.example.demo.exception.UserTypeNotAllow;
import com.example.demo.repository.NewRepository;
import com.example.demo.request.CreateNewsRequest;
import com.example.demo.request.NewsRequest;
import com.example.demo.request.UpdateNewsRequest;
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
        convertNewsRequestToNews(updateNewsRequest, news1);
        news1.setUpdateUserId(updateBy);
        return newRepository.save(news1);
    }

    private void convertNewsRequestToNews(UpdateNewsRequest updateNewsRequest, News news) {
        news.setContent(updateNewsRequest.getContent());
        news.setTitle(updateNewsRequest.getTitle());
        news.setLastUpdateTime(new Date().getTime());
    }



    @Override
    public List<News> findAll() {
        return newRepository.findAll();
    }

    @Override
    public Optional<News> findById(String id) {
        return newRepository.findById(id);
    }

    @Override
    public News insert(CreateNewsRequest createNewsRequest, String token) {
        String role = jwtService.parseTokenToRole(token);
        if(!role.equals(ERole.ADMIN.name())){
            throw new UserTypeNotAllow("can't create news with role = " + role);
        }
        return newRepository.insert(convertNewsRequestToNews(createNewsRequest, token));
    }

    private News convertNewsRequestToNews(CreateNewsRequest createNewsRequest, String token) {
        News news = new News();
        news.setCreateUserId(jwtService.parseTokenToUserId(token));
        news.setContent(createNewsRequest.getContent());
        news.setTitle(createNewsRequest.getTitle());
        news.setCreateTime(new Date().getTime());
        return news;
    }

    @Override
    public void deleteNewsById(String id) {
        Optional<News> deleteNews = findById(id);
        if (deleteNews == null) {
            newRepository.deleteById(id);
        }
    }
}
