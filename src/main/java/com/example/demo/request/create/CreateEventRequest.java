package com.example.demo.request.create;

import com.example.demo.constant.StatusEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEventRequest {
    private String createUserId;
    private String banner;

    @Size(max = 200, message = "Title's Characters is less than 200")
    @NotBlank(message = "Title must not be blank")
    private String title;

    @NotBlank(message = "Content must not be blank")
    private String content;

    private StatusEvent status;

    private String timeBegin;

    private String timeEnd;
}