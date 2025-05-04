package com.example.Event.Consumer.Repositary;


import com.example.Event.Consumer.Model.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<EventEntity, Long> {
}
