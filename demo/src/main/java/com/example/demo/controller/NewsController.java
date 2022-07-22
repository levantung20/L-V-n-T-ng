package com.example.demo.controller;

import com.example.demo.domain.News;
import com.example.demo.request.CommentRequest;
import com.example.demo.request.CreateNewsRequest;
import com.example.demo.request.UpdateNewsRequest;
import com.example.demo.response.ResponseObject;
import com.example.demo.service.JwtService;
import com.example.demo.service.NewService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("demo/v1/news/")
@RequiredArgsConstructor
public class NewsController {

    @Autowired
    private JwtService jwtService;

    public final NewService newService;

    @PostMapping()
    private ResponseEntity<ResponseObject> createNews(@RequestHeader("Authorization") String token, @Valid @RequestBody CreateNewsRequest createNewsRequest) {
            return ResponseEntity.ok(new ResponseObject(HttpStatus.CREATED.value(), "Creat news success", newService.insert(createNewsRequest, token)));
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

    @PutMapping("{id}")
    public ResponseEntity<ResponseObject> updateNews(@PathVariable(name = "id") String id, @RequestHeader("Authorization") String token, @RequestBody UpdateNewsRequest updateNewsRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(HttpStatus.OK.value(), "Update successfully", newService.save(id, updateNewsRequest, token)));
    }

    @PostMapping("{id}/comment")
    public String createCommentForNews(@PathVariable("id") String id, @RequestBody CommentRequest commentRequest) {
        return "Create new comment";
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ResponseObject> deleteNews(@PathVariable(name = "id") String id, @RequestHeader("Authorization") String token) {
        String createUserIdCheck = jwtService.parseTokenToUserId(token);
        Optional<News> newsToDelete = newService.findById(id);
        if (!createUserIdCheck.equals(newsToDelete.get().getCreateUserId())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new ResponseObject(HttpStatus.UNAUTHORIZED.value(), "UNAUTHORIZED TO DELETE NEWS", null));
        }
        newService.deleteNewsById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(HttpStatus.OK.value(), "DELETE SUCCESSFULLY!", null));
    }
}