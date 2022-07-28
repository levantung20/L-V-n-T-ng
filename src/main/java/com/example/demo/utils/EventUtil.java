package com.example.demo.utils;

import com.example.demo.constant.StatusEvent;
import com.example.demo.domain.Event;
import com.example.demo.request.create.CreateEventRequest;
import com.example.demo.request.update.UpdateEventRequest;
import com.example.demo.service.JwtService;

import java.util.Date;


public class EventUtil {

    private static EventUtil eventUtil;
    public static EventUtil getInstance(){
        if (eventUtil == null) {
            eventUtil = new EventUtil();
        }
        return eventUtil;
    }

    private EventUtil() {

    }

    private JwtService jwtService = new JwtService();

    public Event convertEventRequestToEvent(CreateEventRequest createEventRequest, String token) {
        System.out.println(createEventRequest);
        Event event = new Event();
        event.setCreateUserId(jwtService.parseTokenToUserId(token));
        event.setBanner(createEventRequest.getBanner());
        event.setTitle(createEventRequest.getTitle());
        event.setContent(createEventRequest.getContent());
        event.setStatusEvent(StatusEvent.INCOMING);
        event.setTimeBegin(createEventRequest.getTimeBegin());
        event.setTimeEnd(createEventRequest.getTimeEnd());
        event.setCreateTime(new Date().getTime());
        return event;
    }

    public Event convertEventRequestToEvent1(UpdateEventRequest updateEventRequest, Event event) {
        event.setBanner(updateEventRequest.getBanner());
        event.setTitle(updateEventRequest.getTitle());
        event.setContent(updateEventRequest.getContent());
        event.setStatusEvent(updateEventRequest.getStatus());
        event.setTimeBegin(updateEventRequest.getTimeBegin());
        event.setTimeEnd(updateEventRequest.getTimeEnd());
        return event;
    }
}
