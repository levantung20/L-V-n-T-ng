package com.example.demo.converter;

import com.example.demo.domain.News;
import com.example.demo.response.NewsResponse;

public class NewConverter {

    public static NewsResponse convertToNewsResponse(News news, int commentNumber) {
        NewsResponse newsResponse = new NewsResponse();
        newsResponse.setTitle(news.getTitle());
        newsResponse.setBanner(news.getBanner());
        newsResponse.setContent(news.getContent());
        newsResponse.setHashTag(news.getHashTag());
        newsResponse.setLastUpdatedDate(DateConvert.convertLongToDate(news.getLastUpdatedDate()));
        newsResponse.setCommentNumber(commentNumber);
        return newsResponse;
    }
}
