package com.event.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.event.entity.Event;
import com.event.exception.ResourceNotFoundException;
import com.event.repository.EventRepository;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event getEventById(Long id) throws ResourceNotFoundException{
        return eventRepository.findById(id)
        		.orElseThrow(() -> new ResourceNotFoundException("Event Not Found"));
    }

    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event updateEvent(Long id, Event eventDetails) throws ResourceNotFoundException{
        Event event = eventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Event Not Found"));
        event.setEventName(eventDetails.getEventName());
        event.setDate(eventDetails.getDate());
        event.setTime(eventDetails.getTime());
        event.setLocation(eventDetails.getLocation());
        event.setDescription(eventDetails.getDescription());
        event.setOrganizer(eventDetails.getOrganizer());
        return eventRepository.save(event);
    }

    public void deleteEvent(Long id) throws ResourceNotFoundException{
        eventRepository.deleteById(id);
    }
}
