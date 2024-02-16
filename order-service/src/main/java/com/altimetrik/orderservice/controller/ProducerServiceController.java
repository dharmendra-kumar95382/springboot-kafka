package com.altimetrik.orderservice.controller;

import com.altimetrik.basedomain.dto.Order;
import com.altimetrik.basedomain.dto.OrderEvent;
import com.altimetrik.orderservice.kafka.OrderProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class ProducerServiceController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerServiceController.class);

    private OrderProducer orderProducer;

    public ProducerServiceController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }


    @PostMapping("/orders")
    public String placeOrder(@RequestBody Order order){
        LOGGER.info("ProducerServiceController:->{}",order);

        order.setOrderId(UUID.randomUUID().toString());
        OrderEvent event = new OrderEvent();
        event.setStatus("PENDING");
        event.setMessage("Order status is in pending state");
        event.setOrder(order);

        orderProducer.sendMessage(event);
        return "Order placed successfully!";
    }
}
