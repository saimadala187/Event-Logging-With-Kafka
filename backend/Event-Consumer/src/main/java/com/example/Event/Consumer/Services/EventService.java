package com.example.Event.Consumer.Services;

import com.example.Event.Consumer.Model.EventEntity;
import com.example.Event.Consumer.Repositary.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {


    @Autowired
    private EventRepository repository;

    public void saveEvent(EventEntity event) {
        repository.save(event);
    }

    public List<EventEntity> getAllEvents() {
        return repository.findAll();
    }
}
