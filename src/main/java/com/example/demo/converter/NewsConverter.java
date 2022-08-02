package com.example.demo.converter;

import com.example.demo.domain.News;
import com.example.demo.request.create.CreateNewsRequest;
import com.example.demo.request.update.UpdateNewsRequest;
import com.example.demo.response.NewsResponse;
import com.example.demo.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;

public class NewsConverter {

    @Autowired
    private static JwtService jwtService;

    public static NewsResponse convertNewsToNewsResponse(News news, int commentNumber) {
        NewsResponse newsResponse = new NewsResponse();
        newsResponse.setTitle(news.getTitle());
        newsResponse.setBanner(news.getBanner());
        newsResponse.setContent(news.getContent());
        newsResponse.setHashTag(news.getHashTag());
        newsResponse.setCommentNumber(commentNumber);
        return newsResponse;
    }

    public static News convertNewsRequestToNews(String token, CreateNewsRequest request) {
        String userId = jwtService.parseTokenToUserId(token);
        if (userId != null) {
            request.setCreateUserId(userId);
        }
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

