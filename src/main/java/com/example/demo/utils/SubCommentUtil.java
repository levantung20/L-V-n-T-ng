package com.example.demo.utils;

import com.example.demo.domain.SubComment;
import com.example.demo.request.create.CreateSubCommentRequest;

public class SubCommentUtil {
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
