package com.example.demo.request.create;

import com.example.demo.domain.Comment;
import com.example.demo.domain.HashTag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateNewsRequest {
    private String id;
    private String userId;
    private String title;
    private String content;
    private Long lastUpdateTime;
    private String hashTags;
    private List<Comment> comments;

}
