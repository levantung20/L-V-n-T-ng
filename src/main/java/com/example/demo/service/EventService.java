package com.example.demo.service;

import com.example.demo.constant.StatusEvent;
import com.example.demo.domain.Event;
import com.example.demo.request.create.CreateCommentRequest;
import com.example.demo.request.create.CreateEventRequest;
import com.example.demo.request.update.UpdateEventRequest;
import com.example.demo.response.EventIncomingResponse;
import com.example.demo.response.EventResponse;
import com.example.demo.response.EventSearchResponse;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public interface EventService {
    EventResponse insert(String token, CreateEventRequest createEventRequest) throws Exception;

    Event save(UpdateEventRequest updateEventRequest, String eventId, String token);

    void deleteEventById(String eventId, String token);

    EventResponse getEventById(String eventId);

    List<EventSearchResponse> listEventByStatus(int page, int pageSize, StatusEvent statusEvent);

    List<EventResponse> getListEvent();

    List<EventIncomingResponse> getIncomingEvent();

    List<EventSearchResponse> listEventInYear();


}
