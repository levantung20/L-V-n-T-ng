package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Size;
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
    //TODO change UserID To createUserID
    private String createUserId;
    //TODO add updateUserID
    private String updateUserId;
    @Size(max = 200, message = "Title's Characters is less than 200")
    private String title;
    private String content;
    //TODO add createTime
    private  long createTime;
    private Long lastUpdateTime;
    private String hashTags;
    private List<Comment> comments;;

}
