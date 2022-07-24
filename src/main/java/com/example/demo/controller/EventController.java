package com.example.demo.controller;

import com.example.demo.domain.Event;
import com.example.demo.request.create.CreateEventRequest;
import com.example.demo.request.update.UpdateEventRequest;
import com.example.demo.response.ResponseObject;
import com.example.demo.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("demo/v1/events/")
@RequiredArgsConstructor
public class EventController {

    @Autowired
    public EventService eventService;

    @PostMapping()
    public ResponseEntity<ResponseObject> createEvent(@RequestHeader("Authorization") String token,
                                                      @Valid @RequestBody CreateEventRequest createEventRequest){
        return ResponseEntity.ok(new ResponseObject(HttpStatus.OK.value(),
                "Create Event success", eventService.insert(createEventRequest, token)));
    }

    @PutMapping("{eventId}")
    public ResponseEntity<ResponseObject> updateEvent(@PathVariable(name = "eventId") String eventId,
                                                      @Valid
                                                      @RequestBody UpdateEventRequest updateEventRequest,
                                                      @RequestHeader("Authorization") String token){

        Event event = eventService.save(updateEventRequest, eventId, token);
        return ResponseEntity.ok(new ResponseObject(HttpStatus.OK.value(),
                "Update Event Success", event));
    }

    @GetMapping("{eventId}")
    public ResponseEntity<ResponseObject> getDetailEventById(@PathVariable(name = "eventId") String eventId){
        return ResponseEntity.ok(new ResponseObject(HttpStatus.OK.value(),
                "Get Detail Event By EventId " + eventId + " Success", eventService.findById(eventId)));
    }

    @DeleteMapping("{eventId}")
    public ResponseEntity<ResponseObject> deleteEventById(@PathVariable(name = "eventId") String eventId,
                                                          @RequestHeader("Authorization") String token) {
        eventService.deleteEventById(eventId, token);
        return ResponseEntity.ok(new ResponseObject(HttpStatus.OK.value(),
                "Delete Event Success", null));
    }
}
