package com.example.demo.controller;

import com.example.demo.request.NewsRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("demo/v1/news/")
public class NewsController {

    @GetMapping()
    public String getNewsByHashTag(@RequestParam(name = "hashtag") String hashTag) {
        return "Get list news by hashtag " + hashTag;
    }

    @GetMapping("{id}")
    public String getNewsById(@PathVariable(name = "id") String id) {
        return "Get news by id " + id;
    }

    @PostMapping()
    public String createNews(@RequestBody NewsRequest newsRequest) {
        return "Create news success!";
    }

    @PutMapping()
    public String updateNews(@RequestBody NewsRequest newsRequest) {
        return "Update news success!";
    }

    @PostMapping("{id}/comment")
    public String createCommentForNews(@PathVariable("id") String id, @RequestBody CommentRequest commentRequest) {
        return "Create new comment";
    }

}