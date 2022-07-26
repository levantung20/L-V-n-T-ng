package com.example.demo.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.ArrayList;
import java.util.List;

@Data
public class Comment {
    @Id
    private String id;

    private String entityId;

    private String userId;

    private String content;

    private Long createdDate;

    @DBRef
    private List<SubComment> subComment = new ArrayList<>();
}
