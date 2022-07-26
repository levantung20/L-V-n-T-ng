package com.example.demo.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewsResponse {
    private String title;
    private String content;
    private String banner;
    private String hashTag;
    private LocalDate createdDate;
    private LocalDate lastUpdatedDate;
    private int commentNumber;

    public NewsResponse(String title, String content, String banner, String hashTag, Long createdDate, Long lastUpdatedDate, int commentNumber) {
        this.title = title;
        this.content = content;
        this.banner = banner;
        this.hashTag = hashTag;
        if (createdDate != null) {
            this.createdDate = LocalDate.ofEpochDay(Duration.ofMillis(createdDate).toDays());
        }
        if (lastUpdatedDate != null) {
            this.lastUpdatedDate = LocalDate.ofEpochDay(Duration.ofMillis(lastUpdatedDate).toDays());
        }
        this.commentNumber = commentNumber;
    }
}
