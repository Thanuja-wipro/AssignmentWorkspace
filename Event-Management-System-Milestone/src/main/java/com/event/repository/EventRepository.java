package com.event.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.event.entity.Event;

public interface EventRepository extends JpaRepository<Event, Long>{
	@Query("SELECT e FROM Event e JOIN FETCH e.participants WHERE e.id = :eventId")
    Optional<Event> findByIdWithParticipants(@Param("eventId") Long eventId);
}
