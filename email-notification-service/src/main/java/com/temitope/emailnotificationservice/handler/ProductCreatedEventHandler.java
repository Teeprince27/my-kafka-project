package com.temitope.emailnotificationservice.handler;

import com.temitope.common.dto.ProductCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
@Slf4j
@KafkaListener(topics="product-created-events-topic")
public class ProductCreatedEventHandler {
	

	@KafkaHandler
	public void handle(ProductCreatedEvent productCreatedEvent) {
		log.info("Received a new event: " + productCreatedEvent.getTitle());
	}
	
}
