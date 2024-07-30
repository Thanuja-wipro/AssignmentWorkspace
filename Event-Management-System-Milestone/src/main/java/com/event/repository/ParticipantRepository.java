package com.event.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.event.entity.Event;
import com.event.entity.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Long>{
	List<Participant> findByEvent(Event event);
}
