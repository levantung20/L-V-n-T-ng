package com.example.demo.dto;

import com.example.demo.domain.Event;
import com.example.demo.request.create.CreateEventRequest;
import com.example.demo.request.update.UpdateEventRequest;
import com.example.demo.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;


public class EventDto {

    private static EventDto eventDto;
    public static EventDto getInstance(){
        if (eventDto == null) {
            eventDto = new EventDto();
        }
        return eventDto;
    }

    private EventDto() {

    }

    private JwtService jwtService = new JwtService();

    public Event convertEventRequestToEvent(CreateEventRequest createEventRequest, String token) {
        Event event = new Event();
        event.setCreateUserId(jwtService.parseTokenToUserId(token));
        event.setBanner(createEventRequest.getBanner());
        event.setTitle(createEventRequest.getTitle());
        event.setContent(createEventRequest.getContent());
        event.setStatus(createEventRequest.getStatus());
        event.setTimeBegin(createEventRequest.getTimeBegin());
        event.setTimeEnd(createEventRequest.getTimeEnd());
        event.setCreateTime(new Date().getTime());
        return event;
    }

    public Event convertEventRequestToEvent1(UpdateEventRequest updateEventRequest, Event event) {
        event.setBanner(updateEventRequest.getBanner());
        event.setTitle(updateEventRequest.getTitle());
        event.setContent(updateEventRequest.getContent());
        event.setStatus(updateEventRequest.getStatus());
        event.setTimeBegin(updateEventRequest.getTimeBegin());
        event.setTimeEnd(updateEventRequest.getTimeEnd());
        return event;
    }
}