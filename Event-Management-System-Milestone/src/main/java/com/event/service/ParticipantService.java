package com.event.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.event.entity.Event;
import com.event.entity.Participant;
import com.event.exception.ResourceNotFoundException;
import com.event.repository.EventRepository;
import com.event.repository.ParticipantRepository;

import java.util.List;

@Service
public class ParticipantService {
	
    @Autowired
    private ParticipantRepository participantRepository;
    
    @Autowired
    private EventRepository eventRepository;

    public List<Participant> getAllParticipants() {
        return participantRepository.findAll();
    }

    public Participant getParticipantById(Long id) throws ResourceNotFoundException{
        return participantRepository.findById(id)
        		.orElseThrow(() -> new ResourceNotFoundException("Participant Not Found"));
    }

    public List<Participant> getParticipantByEventId(long eventId) throws ResourceNotFoundException {
		Event event = eventRepository.findById(eventId)
				.orElseThrow(() -> new ResourceNotFoundException("Event Not Found"));
		return participantRepository.findByEvent(event);
	}
    
    public Participant saveParticipant(Participant participant) {
        return participantRepository.save(participant);
    }

    public Participant updateParticipant(Long id, Participant participantDetails) throws ResourceNotFoundException{
    	Participant participant = participantRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Participant Not Found"));
    	
            participant.setName(participantDetails.getName());
            participant.setEmail(participantDetails.getEmail());
            participant.setPhone(participantDetails.getPhone());
            participant.setRegistrationStatus(participantDetails.getRegistrationStatus());
            participant.setEvent(participantDetails.getEvent());
            
            return participantRepository.save(participant);
       
    }

    public boolean deleteParticipant(Long id) {
        return participantRepository.findById(id).map(participant -> {
            participantRepository.delete(participant);
            return true;
        }).orElse(false);
    }
}
