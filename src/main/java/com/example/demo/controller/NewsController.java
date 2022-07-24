package com.example.demo.controller;

import com.example.demo.domain.News;
import com.example.demo.request.create.CreateNewsRequest;
import com.example.demo.request.update.UpdateNewsRequest;
import com.example.demo.response.ResponseObject;
import com.example.demo.service.JwtService;
import com.example.demo.service.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("demo/v1/news/")
public class NewsController {

    @Autowired
    private JwtService jwtService;
    @Autowired
    public NewService newService;

    @PostMapping()
    private ResponseEntity<ResponseObject> createNews(@RequestHeader("Authorization") String token
            , @Valid @RequestBody CreateNewsRequest createNewsRequest) {
        return ResponseEntity.ok(new ResponseObject(HttpStatus.CREATED.value()
                , "Creat news success", newService.insert(createNewsRequest, token)));
    }


    @GetMapping()
    public ResponseEntity<?> getNewsAll(@RequestParam String hashTags, Integer page, Integer pageSize) {
        if (hashTags == null)
            return ResponseEntity.ok(new ResponseObject(HttpStatus.OK.value()
                    , "Creat news success", newService.findAll(page, pageSize)));
        return ResponseEntity.ok(new ResponseObject(HttpStatus.OK.value()
                , "Creat news success", newService.findByHashTag(hashTags, page, pageSize)));

    }


    @GetMapping("{id}")
    public ResponseEntity<ResponseObject> getDetailNewsById(@PathVariable(name = "id") String id) {
        return ResponseEntity.ok(new ResponseObject(HttpStatus.OK.value()
                , "Get detail news by id" + id, newService.findById(id)));
    }


    @PutMapping("{id}")
    public ResponseEntity<ResponseObject> updateNews(@PathVariable(name = "id") String id
            , @RequestHeader("Authorization") String token
            , @RequestBody UpdateNewsRequest updateNewsRequest) {
        News news = newService.save(id, updateNewsRequest, token);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseObject(HttpStatus.OK.value()
                        , "Update successfully"
                        , news));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ResponseObject> deleteNews(@PathVariable(name = "id") String id, @RequestHeader("Authorization") String token) {
        String createUserIdCheck = jwtService.parseTokenToUserId(token);
       News newsToDelete = newService.findById(id);
        if (!createUserIdCheck.equals(newsToDelete.getCreateUserId())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new ResponseObject(HttpStatus.UNAUTHORIZED.value(), "UNAUTHORIZED TO DELETE NEWS", null));
        }
        newService.deleteNewsById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(HttpStatus.OK.value(), "DELETE SUCCESSFULLY!", null));

    }
}