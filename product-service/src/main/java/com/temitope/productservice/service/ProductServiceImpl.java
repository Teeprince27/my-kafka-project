package com.temitope.productservice.service;

import com.temitope.common.dto.ProductCreatedEvent;
import com.temitope.productservice.dao.ProductRepository;
import com.temitope.productservice.dto.CreateProductRequestDto;
import com.temitope.productservice.model.CreateProductRestModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

	private final KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate;
	private final ProductRepository productRepository;

//	public ProductServiceImpl(KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate) {
//		this.kafkaTemplate = kafkaTemplate;
//	}

	@Override
	public String createProduct(CreateProductRequestDto productRestModel) throws Exception {
		

		// TODO: Persist Product Details into database table before publishing an Event
		CreateProductRestModel createProductRestModel = new CreateProductRestModel();
		createProductRestModel.setTitle(productRestModel.getTitle());
		createProductRestModel.setPrice(productRestModel.getPrice());
		createProductRestModel.setQuantity(productRestModel.getQuantity());

		CreateProductRestModel createProductResponse = productRepository.save(createProductRestModel);

		String productId = createProductResponse.getProductId();
		ProductCreatedEvent productCreatedEvent = new ProductCreatedEvent();
		productCreatedEvent.setProductId(productId);
		productCreatedEvent.setTitle(productRestModel.getTitle());
		productCreatedEvent.setPrice(productRestModel.getPrice());
		productCreatedEvent.setQuantity(productRestModel.getQuantity());

		
		log.info("Before publishing a ProductCreatedEvent {}, {} ",productId,  productCreatedEvent);
		
		SendResult<String, ProductCreatedEvent> result = 
				kafkaTemplate.send("product-created-events-topic",productId, productCreatedEvent).get();
		
		log.info("Partition: " + result.getRecordMetadata().partition());
		log.info("Topic: " + result.getRecordMetadata().topic());
		log.info("Offset: " + result.getRecordMetadata().offset());
		
		log.info("***** Returning product id");
		
		return productId;
	}

}
