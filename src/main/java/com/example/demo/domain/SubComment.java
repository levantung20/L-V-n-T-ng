package com.example.demo.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class SubComment {
    @Id
    private String id;

    private String entityId;

    private String commentId;

    private String userId;

    private String content;

    private Long createdDate;
}
