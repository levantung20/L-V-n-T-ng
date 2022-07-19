package com.example.demo.controller;

import com.example.demo.domain.Event;
import com.example.demo.repository.EventRepository;
import com.example.demo.request.CommentRequest;
import com.example.demo.request.EventRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("demo/v1/events/")
public class EventController {

    private final EventRepository eventRepository;

    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }


    @GetMapping()
    public String getListEvent() {
        System.out.println(eventRepository.findByTitleLike("picnic").getTitle());;
        return "Get list event success! v3";
    }

    @GetMapping("{id}")
    public String getEventById(@PathVariable(name = "id") String id) {
        return "Get event by id " + id;
    }

    @PostMapping()
    public Event createEvent(@RequestBody Event event) {
        return eventRepository.save(event);
    }

    @PutMapping()
    public String updateEvent(@RequestBody EventRequest eventRequest) {
        return "Update event success!";
    }

    @PostMapping("{id}/comment")
    public String createCommentForEvent(@PathVariable("id") String id, @RequestBody CommentRequest commentRequest) {
        return "Create new comment";
    }
}
