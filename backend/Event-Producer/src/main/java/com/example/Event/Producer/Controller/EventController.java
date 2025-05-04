package com.example.Event.Producer.Controller;


import com.example.Event.Producer.Model.EventRequest;
import com.example.Event.Producer.Service.KafkaProducerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EventController {

    @Autowired
    private KafkaProducerService producer;

    @PostMapping("/user/login")
    public ResponseEntity<String> userLogin(@RequestBody EventRequest request) {
        String json = null;
        try {
            json = new ObjectMapper().writeValueAsString(request);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        producer.sendEvent("user-events", json);
        return ResponseEntity.ok("Event sent");
    }

    @PostMapping("/product/create")
    public ResponseEntity<String> productCreated(@RequestBody EventRequest request)  {
        String json = null;
        try {
            json = new ObjectMapper().writeValueAsString(request);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        producer.sendEvent("product-events", json);
        return ResponseEntity.ok("Event sent");
    }

    @PostMapping("/order/fail")
    public ResponseEntity<String> orderFailed(@RequestBody EventRequest request)  {
        String json = null;
        try {
            json = new ObjectMapper().writeValueAsString(request);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        producer.sendEvent("order-events", json);
        return ResponseEntity.ok("Event sent");
    }
}
