package com.example.demo.domain;

import com.example.demo.constant.StatusEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Size;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    @Id
    private String id;

    private String banner;

    private String createUserId;

    private String updateUserId;

    @Size(max = 200, message = "Title's Characters is less than 200")
    private String title;

    private String content;

    private StatusEvent statusEvent;

    private String timeBegin;

    private String timeEnd;

    private Long createTime;

    private Long updateTime;

    private List<Comment> comments = new ArrayList<>();


}
