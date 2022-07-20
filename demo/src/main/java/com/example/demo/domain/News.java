package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class News {
    @Id
    private String id;
    private String userId;
    private String title;
    private String content;
    private Long lastUpdateTime;
    private List<HashTag> hashTags;
    private List<Comment> comments;

}
