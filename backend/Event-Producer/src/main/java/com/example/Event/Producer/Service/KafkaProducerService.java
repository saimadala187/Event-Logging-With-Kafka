package com.example.Event.Producer.Service;

import com.example.Event.Producer.Model.EventRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    // This class will contain the logic to produce messages to Kafka
    // For example, you can use KafkaTemplate to send messages to a specific topic
    // You can also implement methods to handle different types of events
    // and send them to the appropriate Kafka topic

    // Example method to send a event to a Kafka topic/

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducerService.class);


    public void sendEvent(String topic, String message) {
        kafkaTemplate.send(topic, message);
        logger.info("📤 Sending event to topic [{}]: {}", topic, message);
        System.out.println("📤 Sent to Kafka topic [" + topic + "] → " + message);
    }



}
