package com.example.demo.service;

import com.example.demo.domain.Event;
import com.example.demo.request.create.CreateEventRequest;
import com.example.demo.request.update.UpdateEventRequest;

public interface EventService {
    Event insert(CreateEventRequest createEventRequest, String token);

    Event save(UpdateEventRequest updateEventRequest, String eventId, String token);

    Event findById(String id);

    void deleteEventById(String eventId, String token);

}
