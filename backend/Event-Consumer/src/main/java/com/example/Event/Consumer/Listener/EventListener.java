package com.example.Event.Consumer.Listener;


import com.example.Event.Consumer.Model.EventEntity;
import com.example.Event.Consumer.Services.EventService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class EventListener {

    @Autowired
    private EventService eventService;
    private static final Logger logger = LoggerFactory.getLogger(EventListener.class);


    @KafkaListener(topics = {"user-events", "product-events", "order-events"}, groupId = "event-consumer-group")
    public void handleEvent(String message,@Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        try {
            logger.info("📥 Received event from topic [{}]: {}", topic, message);

            ObjectMapper mapper = new ObjectMapper();
            JsonNode json = mapper.readTree(message);

            EventEntity event = new EventEntity();
            event.setUserId(json.get("userId").asText());
            event.setEventType(json.get("eventType").asText());
            event.setDescription(json.get("description").asText());
            event.setTimestamp(LocalDateTime.now());

            eventService.saveEvent(event);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("❌ Failed to process message: {}", message, e);
        }
    }
}