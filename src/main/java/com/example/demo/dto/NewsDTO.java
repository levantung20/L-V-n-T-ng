package com.example.demo.dto;

import com.example.demo.domain.News;
import com.example.demo.request.create.CreateNewsRequest;
import com.example.demo.request.update.UpdateNewsRequest;
import com.example.demo.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;

public class NewsDTO {

    public static News convertNewsRequestToNews(CreateNewsRequest request) {
        News news = new News();
        news.setCreateUserId(request.getCreateUserId());
        news.setContent(request.getContent());
        news.setTitle(request.getTitle());
        news.setCreatedDate(System.currentTimeMillis());
        news.setLastUpdatedDate(System.currentTimeMillis());
        news.setHashTag(request.getHashTags());
        return news;
    }

    public static News convertNewsRequestToNews1(UpdateNewsRequest request, News news) {
        news.setContent(request.getContent());
        news.setTitle(request.getTitle());
        news.setLastUpdatedDate(System.currentTimeMillis());
        news.setHashTag(request.getHashTags());
        return news;
    }
}

