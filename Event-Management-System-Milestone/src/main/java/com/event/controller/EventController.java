package com.event.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.event.entity.Event;
import com.event.exception.ResourceNotFoundException;
import com.event.service.EventService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService eventService;
    
    //http://localhost:6060/api/events
    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }
    
    //http://localhost:6060/api/events/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) throws ResourceNotFoundException{
        Event event = eventService.getEventById(id);
        return ResponseEntity.ok().body(event);
    }
    
    //http://localhost:6060/api/events
    @PostMapping
    public Event createEvent(@Valid @RequestBody Event event) {
        return eventService.saveEvent(event);
    }
    
    //http://localhost:6060/api/events/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long id, @Valid @RequestBody Event eventDetails) throws ResourceNotFoundException{
      Event updatedEvent = eventService.updateEvent(id, eventDetails);
      return ResponseEntity.ok().body(updatedEvent);
       
    }

    //http://localhost:6060/api/events/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) throws ResourceNotFoundException{
        eventService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }
}
