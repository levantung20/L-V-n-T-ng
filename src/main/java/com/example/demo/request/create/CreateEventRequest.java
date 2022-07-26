package com.example.demo.request.create;

import com.example.demo.constant.StatusEvent;
import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(pattern="dd-MM-yyyy hh:mm:ss")
    @NotBlank(message = "Time begin must not be blank")
    private String timeBegin;

    @JsonFormat(pattern="dd-MM-yyyy hh:mm:ss")
    @NotBlank(message = "Time end must not be blank")
    private String timeEnd;

    private String startTime;


}
