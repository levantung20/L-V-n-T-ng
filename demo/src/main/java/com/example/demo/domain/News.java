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
    private Long createdDate;
    private String createdBy;
    private String updateBy;
    private String title;
    private String content;
    private Long lastUpdateTime;
    private String hashTags;
    private List<Comment> comments;

}
