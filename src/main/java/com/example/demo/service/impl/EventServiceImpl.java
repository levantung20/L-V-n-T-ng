package com.example.demo.service.impl;

import com.example.demo.constant.ERole;
import com.example.demo.domain.Event;
import com.example.demo.dto.EventDto;
import com.example.demo.exception.EventNotFoundException;
import com.example.demo.exception.UserTypeNotAllow;
import com.example.demo.repository.EventRepository;
import com.example.demo.request.create.CreateEventRequest;
import com.example.demo.request.update.UpdateEventRequest;
import com.example.demo.service.EventService;
import com.example.demo.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private JwtService jwtService;

    @Autowired
    public EventRepository eventRepository;

    @Override
    public Event insert(CreateEventRequest createEventRequest, String token) {
        String erole = jwtService.parseTokenToRole(token);

        if (!erole.equals(ERole.ADMIN.toString())){
            throw new UserTypeNotAllow("Can't create news with role" + erole);
        }
        return eventRepository.insert(EventDto.getInstance().convertEventRequestToEvent(createEventRequest, token));
    }

    @Override
    public Event save(UpdateEventRequest updateEventRequest, String eventId, String token) {
        Event event = eventRepository.findById(eventId).get();
        if (event == null){
            throw new EventNotFoundException("Can't find Event with id = " + eventId);
        }
        ERole eRole = ERole.valueOf(jwtService.parseTokenToRole(token));
        if (!eRole.equals(ERole.ADMIN)) {
            throw new UserTypeNotAllow("Can't update event with role equal user");
        }

        String IdUserUpdate = jwtService.parseTokenToUserId(token);
        EventDto.getInstance().convertEventRequestToEvent1(updateEventRequest, event);
        event.setUpdateUserId(IdUserUpdate);
        event.setUpdateTime(System.currentTimeMillis());
        return eventRepository.save(event);
    }

    @Override
    public Event findById(String eventId) {
        Event event = eventRepository.findById(eventId).get();
        if (event == null) {
            throw new EventNotFoundException("Can't find event with eventId = " + eventId);
        }
        return event;
    }

    @Override
    public void deleteEventById(String eventId, String token) {
        Event event = eventRepository.findById(eventId).get();
        if (event == null){
            throw new EventNotFoundException("Can't delete eventId = " + eventId + " , it does not exit");
        }
        String userIdCreatEvent = jwtService.parseTokenToUserId(token);
        if (!userIdCreatEvent.equals(event.getCreateUserId())) {
            throw new UserTypeNotAllow("No permission to delete (Only the event creator can delete)");
        }
        eventRepository.deleteById(eventId);
    }

}
