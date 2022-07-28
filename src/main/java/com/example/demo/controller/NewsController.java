package com.example.demo.controller;

import com.example.demo.annotation.RoleAdmin;
import com.example.demo.constant.ERole;
import com.example.demo.domain.Comment;
import com.example.demo.domain.JWTData;
import com.example.demo.domain.News;
import com.example.demo.exception.UserTypeNotAllow;
import com.example.demo.request.create.CreateCommentRequest;
import com.example.demo.request.create.CreateNewsRequest;
import com.example.demo.request.create.CreateSubCommentRequest;
import com.example.demo.request.update.UpdateNewsRequest;
import com.example.demo.response.*;
import com.example.demo.service.JwtService;
import com.example.demo.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("demo/v1/news/")
public class NewsController {

    @Autowired
    public NewsService newsService;
    @Autowired
    private JwtService jwtService;

    @RoleAdmin
    @PostMapping()
    private ResponseEntity<ResponseObject> createNews(
            @RequestHeader("Authorization") String token,
            @Valid @RequestBody CreateNewsRequest request) {
//        String role = jwtService.parseTokenToRole(token);
//        if (!role.equals(ERole.ADMIN.name())) {
//            throw new UserTypeNotAllow("can't create news with role = " + role);
//        }

        News newsEntity = newsService.insert(token, request);
        return ResponseEntity.ok(new ResponseObject(HttpStatus.CREATED.value(),
                "Creat news success", newsEntity));
    }

    @GetMapping()
    public ResponseEntity<ResponseObject> findAllNewsByHashTag(@RequestParam("hashTag") String hashTag,
                                                               @RequestParam(defaultValue = "0", required = false) int page ,
                                                               @RequestParam(defaultValue = "24", required = false) int pageSize) {
        NewSearchResponse newsResponse = newsService.findByHashTag(hashTag, page, pageSize);
        return ResponseEntity.ok(new ResponseObject(HttpStatus.OK.value(),
                "Creat news success", newsResponse));
    }


    @GetMapping("detail/{newsId}")
    public ResponseEntity<ResponseObject> getDetailNewsById(@PathVariable(name = "newsId") String newsId) {
        NewsResponse newsResponse = newsService.getNewsDetailById(newsId);
        return ResponseEntity.ok(new ResponseObject(HttpStatus.OK.value()
                , "Get detail news by id" + newsId, newsResponse));
    }


    @RoleAdmin
    @PutMapping("{id}")
    public ResponseEntity<ResponseObject> updateNews(
            @RequestHeader("Authorization") String token,
            @PathVariable(name = "id") String id,
            @RequestBody UpdateNewsRequest request) {
//        ERole eRole = ERole.valueOf(jwtService.parseTokenToRole(token));
//        if (!eRole.equals(ERole.ADMIN)) {
//            throw new UserTypeNotAllow("can't not update news with role equal user");
//        }
        String updateBy = jwtService.parseTokenToUserId(token);
        JWTData data = jwtService.getDataFromToken(token);
        data.getUserId();
        if (updateBy != null) {
            request.setUpdateUserId(updateBy);
        }

        News news = newsService.updateById(id, request);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseObject(HttpStatus.OK.value()
                        , "Update successfully"
                        , news));
    }


    @DeleteMapping("{newsId}")
    public ResponseEntity<ResponseObject> deleteNews(@PathVariable(name = "newsId") String newsId
            , @RequestHeader("Authorization") String token) {
        newsService.deleteNewsById(newsId, token);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseObject(HttpStatus.OK.value()
                        , "DELETE SUCCESSFULLY!", null));
    }

    @PostMapping("{newsId}/comments")
    public ResponseEntity<ResponseObject> addCommentToNews(@PathVariable(name = "newsId") String newsId,
                                                           @RequestHeader("Authorization") String token,
                                                           @RequestBody CreateCommentRequest request) {
        News newsEntity = newsService.addComment(newsId, token, request);
        return ResponseEntity.ok(new ResponseObject(HttpStatus.OK.value(),
                "Comment To News Success", newsEntity));
    }

    @DeleteMapping("{commentId}/comments")
    public ResponseEntity<ResponseObject> deleteComment(@PathVariable(name = "commentId") String commentId,
                                                        @RequestHeader("Authorization") String token) {
        newsService.deleteComment(commentId, token);
        return ResponseEntity.ok(new ResponseObject(HttpStatus.OK.value(),
                "Delete Comment Success", null));
    }

    @GetMapping("{newsId}/commentNumber")
    public ResponseEntity<ResponseObject> showCommentNumber(@PathVariable(name = "newsId") String newsId) {
        newsService.showCommentNumber(newsId);
        return ResponseEntity.ok(new ResponseObject(HttpStatus.OK.value(),
                "Show comment number success", null));
    }

    @PostMapping("{commentId}/subComment")
    public ResponseEntity<ResponseObject> addSubCommentToComment(@RequestHeader("Authorization") String token,
                                                                 @PathVariable(name = "commentId") String commentId,
                                                                 @RequestBody CreateSubCommentRequest createSubCommentRequest) {
        Comment comment = newsService.addSubCommentToComment(token, commentId, createSubCommentRequest);
        return ResponseEntity.ok(new ResponseObject(HttpStatus.OK.value(),
                "Add SubComment To Success", comment));
    }

    @DeleteMapping("subcomment/{subCommentId}")
    public ResponseEntity<ResponseObject> deleteSubCommentById(@RequestHeader("Authorization") String token,
                                                               @PathVariable(name = "subCommentId") String subCommentId) {
        newsService.deleteComment(token, subCommentId);
        return ResponseEntity.ok(new ResponseObject(HttpStatus.OK.value(),
                "Delete SubComment Success", null));
    }

    @GetMapping("{newsId}/comments")
    public ResponseEntity<ResponseObject> getListCommentByNewsId(@PathVariable(name = "newsId") String newsId,
                                                                 @RequestParam(defaultValue = "0", required = false) int page ,
                                                                 @RequestParam(defaultValue = "24", required = false) int pageSize) {
        List<CommentResponse> commentResponse = newsService.getListComment(newsId, page, pageSize);
        return ResponseEntity.ok(new ResponseObject(HttpStatus.OK.value(),
                "Get List Comment By News Id Success", commentResponse));
    }


}