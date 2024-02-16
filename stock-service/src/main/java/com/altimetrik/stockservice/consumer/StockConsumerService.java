package com.altimetrik.stockservice.consumer;

import com.altimetrik.basedomain.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class StockConsumerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(StockConsumerService.class);

    @KafkaListener(topics = "${spring.kafka.topic.name}",groupId = "${spring.kafka.consumer.group-id}")
    public void consumerMessage(OrderEvent orderEvent){
        LOGGER.info("StockConsumerService:->{}",orderEvent);
    }
}
