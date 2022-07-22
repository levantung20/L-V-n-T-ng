package com.example.demo.dto;

import com.example.demo.domain.News;
import com.example.demo.request.create.CreateNewsRequest;
import com.example.demo.request.update.UpdateNewsRequest;
import com.example.demo.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class NewsDTO {
    @Autowired
    private static JwtService jwtService;
    public static News convertNewsRequestToNews(CreateNewsRequest createNewsRequest, String token) {
        News news = new News();
        news.setCreateUserId(jwtService.parseTokenToUserId(token));
        news.setContent(createNewsRequest.getContent());
        news.setTitle(createNewsRequest.getTitle());
        news.setCreateTime(new Date().getTime());
        news.setHashTags(createNewsRequest.getHashTags());
        return news;
    }

    public static News convertNewsRequestToNews1(UpdateNewsRequest updateNewsRequest, News news) {
        news.setContent(updateNewsRequest.getContent());
        news.setTitle(updateNewsRequest.getTitle());
        news.setLastUpdateTime(new Date().getTime());
        news.setHashTags(updateNewsRequest.getHashTags());
        return news;
    }
}

