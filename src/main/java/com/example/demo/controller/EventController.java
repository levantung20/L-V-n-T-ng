package com.example.demo.controller;

import com.example.demo.domain.Event;
import com.example.demo.request.create.CreateCommentRequest;
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
import java.util.Optional;

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

    @DeleteMapping("{eventId}")
    public ResponseEntity<ResponseObject> deleteEventById(@PathVariable(name = "eventId") String eventId,
                                                          @RequestHeader("Authorization") String token) {
        eventService.deleteEventById(eventId, token);
        return ResponseEntity.ok(new ResponseObject(HttpStatus.OK.value(),
                "Delete Event Success", null));
    }

    @PostMapping("/{eventId}/comments")
    public ResponseEntity<ResponseObject> addCommentToEvent(@PathVariable(name = "eventId") String eventId,
                                                            @RequestHeader("Authorization") String token,
                                                            @RequestBody CreateCommentRequest createCommentRequest) {
        return ResponseEntity.ok(new ResponseObject(HttpStatus.OK.value(),
                "Comment to Event Success", eventService.addCommentToEvent(eventId, token, createCommentRequest)));
    }

    @GetMapping("statusEvent")
    public ResponseEntity<ResponseObject> getListEventByStatusEvent(@RequestParam(name = "statusEvent") String statusEvent,
                                                                    Integer page, Integer pageSize) {
        eventService.getListEventByStatusEvent(statusEvent, page, pageSize);
        return ResponseEntity.ok(new ResponseObject(HttpStatus.OK.value(),
                "Get list event by status event success", null));
    }

    @DeleteMapping("/{eventId}/comments")
    public ResponseEntity<ResponseObject> deleteComment(@PathVariable(name = "eventId") String eventId,
                                                        @RequestHeader("Authorization") String token) {
        eventService.deleteComment(eventId, token);
        return ResponseEntity.ok(new ResponseObject(HttpStatus.OK.value(),
                "Delete Comment Success", null));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getEventById(@PathVariable(name = "id") String id){
        Optional<Event> findById = Optional.ofNullable(eventService.findById(id));
        if (findById.isPresent()) {
            Event event = eventService.getEventStatus(findById.get());
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(HttpStatus.OK.value(),"Get events with id" + id, event));
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ResponseObject(HttpStatus.NO_CONTENT.value(),"Event with id " + id + "is empty!",null));
    }
}
