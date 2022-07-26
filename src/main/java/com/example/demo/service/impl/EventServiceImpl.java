package com.example.demo.service.impl;

import com.example.demo.constant.ERole;
import com.example.demo.domain.Comment;
import com.example.demo.domain.Event;
import com.example.demo.dto.EventDto;
import com.example.demo.exception.EventNotFoundException;
import com.example.demo.exception.UserTypeNotAllow;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.EventRepository;
import com.example.demo.request.create.CreateCommentRequest;
import com.example.demo.request.create.CreateEventRequest;
import com.example.demo.request.update.UpdateEventRequest;
import com.example.demo.service.EventService;
import com.example.demo.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private JwtService jwtService;

    @Autowired
    public EventRepository eventRepository;

    @Autowired
    public CommentRepository commentRepository;

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

    @Override
    public Event addCommentToEvent(String eventId, String token, CreateCommentRequest createCommentRequest) {
        Event event = eventRepository.findById(eventId).get();
        if (event == null) {
            throw new EventNotFoundException("EventId does not exit");
        }
        String userId = jwtService.parseTokenToUserId(token);
        Comment comment = new Comment();
        comment.setEntityId(eventId);
        comment.setUserId(userId);
        comment.setContent(createCommentRequest.getContent());
        comment.setCreatedDate(System.currentTimeMillis());
        commentRepository.save(comment);
        event.getComments().add(comment);
        return eventRepository.save(event);
    }

    @Override
    public List<Event> getListEventByStatusEvent(String statusEvent, Integer page, Integer pageSize) {
        List<Event> events = eventRepository.findEventByStatusEvent(statusEvent).stream().skip((page - 1) * pageSize)
                .limit(pageSize).collect(Collectors.toList());
        if (events.isEmpty()) {
            throw new EventNotFoundException("Status Event does not exist");
        }
        return events;
    }

    @Override
    public void deleteComment(String eventId, String token) {
        Event event = eventRepository.findById(eventId).get();
        if (event == null) {
            throw new EventNotFoundException("EventId does not exist");
        }
        String userId = jwtService.parseTokenToUserId(token);
        if (!event.getCreateUserId().equals(userId)) {
            throw new EventNotFoundException("Unauthorized to delete comment");
        }
        eventRepository.deleteById(eventId);
    }



}
