package com.example.demo.controller;

import com.example.demo.constant.ERole;
import com.example.demo.domain.News;
import com.example.demo.request.CommentRequest;
import com.example.demo.request.NewsRequest;
import com.example.demo.response.ResponseObject;
import com.example.demo.service.JwtService;
import com.example.demo.service.NewService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("demo/v1/news/")
@RequiredArgsConstructor
public class NewsController {

    @Autowired
    private JwtService jwtService;

    public final NewService newService;

    @PostMapping()
    private ResponseEntity<ResponseObject> createNews(@RequestHeader("Authorization") String token, @RequestBody NewsRequest newsRequest) {
        ERole eRole = ERole.valueOf(jwtService.parseTokenToRole(token));
        if (eRole.equals(ERole.ADMIN)) {
            News news = newService.save(token, newsRequest);
            return ResponseEntity.ok(new ResponseObject(HttpStatus.CREATED.value(), "Creat news success", news));
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                .body(new ResponseObject(HttpStatus.NOT_ACCEPTABLE.value(), "Can not creat news", null));
    }

    @GetMapping()
    public ResponseEntity<?> getNewsAll() {
        return ResponseEntity.ok(new ResponseObject(HttpStatus.OK.value(), "Creat news success", newService.findAll()));
    }


    @GetMapping("{id}")
    public ResponseEntity<ResponseObject> getDetailNewsById(@PathVariable(name = "id") String id) {
        Optional<News> news = newService.findById(id);
        if (news.isPresent()) {
            return ResponseEntity.ok(new ResponseObject(HttpStatus.OK.value(), "Get detail news by id" + id, news));
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                .body(new ResponseObject(HttpStatus.NOT_ACCEPTABLE.value(), "Can not get news by id", null));
    }

    @PutMapping()
    public ResponseEntity<ResponseObject> updateNews(@RequestHeader("Authorization") String token, @RequestBody NewsRequest newsRequest) {
        Optional<News> news = newService.findById(newsRequest.getId());
        if (news.isPresent()) {
            ERole eRole = ERole.valueOf(jwtService.parseTokenToRole(token));
            if (eRole.equals(ERole.ADMIN)) {
                News news1 = newService.save(token, newsRequest);
                return ResponseEntity.ok(new ResponseObject(HttpStatus.OK.value(), "Update success", news1));
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                .body(new ResponseObject(HttpStatus.NOT_ACCEPTABLE.value(), "Update not success", null));
    }

    @PostMapping("{id}/comment")
    public String createCommentForNews(@PathVariable("id") String id, @RequestBody CommentRequest commentRequest) {
        return "Create new comment";
    }

}