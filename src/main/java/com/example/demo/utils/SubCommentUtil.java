package com.example.demo.dto;

import com.example.demo.domain.SubComment;
import com.example.demo.request.create.CreateSubCommentRequest;

public class SubCommentDTO {
    public static SubComment convertSubCommentRequestToSubComment(CreateSubCommentRequest request, String entityId, String userId, String commentid) {
        return SubComment.builder()
                .userId(userId)
                .entityId(entityId)
                .content(request.getContent())
                .commentId(commentid)
                .createdDate(System.currentTimeMillis())
                .build();
    }
}
