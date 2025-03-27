package com.notificationdunice.intensivgaponovl.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/create-order")
public class OrderController {

    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody Order order) {
        kafkaTemplate.send("order-topic", order);
        return ResponseEntity.ok("Order sent to Kafka");
    }
}