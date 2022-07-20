package com.example.demo.controller;

import com.example.demo.constant.ERole;
import com.example.demo.domain.News;
import com.example.demo.repository.NewRepository;
import com.example.demo.request.NewsRequest;
import com.example.demo.response.ResponseObject;
import com.example.demo.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("demo/v1/news/")
@RequiredArgsConstructor
public class NewsController {

    @Autowired
    private JwtService jwtService;

    private final NewRepository newRepository;

    @PostMapping()
    private ResponseEntity<ResponseObject> createNews(@RequestHeader("Authorization") String token, @RequestBody NewsRequest newsRequest) {
        ERole eRole = ERole.valueOf(jwtService.convertToken(token));
        if (eRole.equals(ERole.ADMIN)){
            News news = new News();
            news.setUserId(newsRequest.getUserId());
            news.setTitle(newsRequest.getTitle());
            news.setContent(newsRequest.getContent());
            news.setLastUpdateTime(newsRequest.getLastUpdateTime());
            news.setComments(newsRequest.getComments());
            news.setHashTags(newsRequest.getHashTags());
            newRepository.save(news);
            return ResponseEntity.ok(new ResponseObject(HttpStatus.CREATED.value(), "Creat news success", news));
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                .body(new ResponseObject(HttpStatus.NOT_ACCEPTABLE.value(), "Can not creat news", null));
    }

    @GetMapping("listNews")
    public ResponseEntity<?> getNewsAll(){
        return ResponseEntity.ok(new ResponseObject(HttpStatus.OK.value(), "Creat news success", newRepository.findAll()));
    }


    @GetMapping("{id}")
    public ResponseEntity<ResponseObject> getDetailNewsById(@PathVariable(name = "id") String id) {
        Optional<News> news = newRepository.findById(id);
        if (news.isPresent()){
            return ResponseEntity.ok(new ResponseObject(HttpStatus.OK.value(), "Get detail news by id" + id, news));
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                .body(new ResponseObject(HttpStatus.NOT_ACCEPTABLE.value(), "Can not get news by id", null));
    }

    @PutMapping("{id}")
    public ResponseEntity<ResponseObject> updateNews(@RequestHeader("Authorization") String token, @PathVariable(name = "id") String id, @RequestBody NewsRequest newsRequest) {
        ERole eRole = ERole.valueOf(jwtService.convertToken(token));
        if (eRole.equals(ERole.ADMIN)){
            News news = new News();
            news.setId(newsRequest.getId());
            news.setUserId(newsRequest.getUserId());
            news.setTitle(newsRequest.getTitle());
            news.setContent(newsRequest.getContent());
            news.setLastUpdateTime(newsRequest.getLastUpdateTime());
            news.setHashTags(newsRequest.getHashTags());
            newRepository.save(news);
            return ResponseEntity.ok(new ResponseObject(HttpStatus.OK.value(), "Update success", news));
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                .body(new ResponseObject(HttpStatus.NOT_ACCEPTABLE.value(), "Update not success", null));
    }

    @PostMapping("{id}/comment")
    public String createCommentForNews(@PathVariable("id") String id, @RequestBody CommentRequest commentRequest) {
        return "Create new comment";
    }

}