package com.event.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.event.entity.Participant;
import com.event.exception.ResourceNotFoundException;
import com.event.service.EventService;
import com.event.service.ParticipantService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/participants")
public class ParticipantController {
	
    @Autowired
    private ParticipantService participantService;
    
    @Autowired
    private EventService eventService;

    //http://localhost:6060/api/participants
    @GetMapping
    public List<Participant> getAllParticipants() {
        return participantService.getAllParticipants();
    }

  //http://localhost:6060/api/participants/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Participant> getParticipantById(@PathVariable Long id) throws ResourceNotFoundException{
        Participant participant = participantService.getParticipantById(id);
        return ResponseEntity.ok().body(participant);
    }
    
 // http://localhost:8211/api/participant/event/12
 	@GetMapping("/event/{eventId}")
 	public ResponseEntity<List<Participant>> getParticipantsByEventId(@PathVariable long eventId)  throws ResourceNotFoundException{
 		List<Participant> list = participantService.getParticipantByEventId(eventId);
 		return ResponseEntity.ok().body(list);
 	}

 	//http://localhost:6060/api/participants
    @PostMapping
    public Participant createParticipant(@RequestBody Participant participant) {
        return participantService.saveParticipant(participant);
    }

    //http://localhost:6060/api/participants/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Participant>
    updateParticipant(@PathVariable Long id, @RequestBody Participant participantDetails) throws ResourceNotFoundException{
        Participant updatedParticipant = participantService.updateParticipant(id, participantDetails);
        return ResponseEntity.ok().body(updatedParticipant);
    }

    //http://localhost:6060/api/participants/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParticipant(@PathVariable Long id) {
        if (participantService.deleteParticipant(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
