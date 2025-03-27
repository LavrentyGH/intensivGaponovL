package com.notificationdunice.intensivgaponovl.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class InventoryListener {

    @KafkaListener(topics = "order-topic", groupId = "inventory-group")
    public void listen(Order order) {
        System.out.println("Received order: " + order);
    }
}