package com.example.demo.request;

import com.example.demo.domain.Comment;
import com.example.demo.domain.HashTag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsRequest {
    private String id;
    //TODO change UserID to createUserID
    private String createUserID;
    //TODO add update
    private String updateUserID;
    private String title;
    private String content;
    //TODO add createTime
    private Long createTime;
    private Long lastUpdateTime;
    private List<HashTag> hashTags;
    private List<Comment> comments;
}
