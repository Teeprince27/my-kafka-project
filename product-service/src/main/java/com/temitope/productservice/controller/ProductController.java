package com.temitope.productservice.controller;

import com.temitope.productservice.dto.CreateProductRestModel;
import com.temitope.productservice.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/products")
public class ProductController {
	
	ProductService productService;
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@PostMapping
	public ResponseEntity<Object> createProduct(@RequestBody CreateProductRestModel product) {
		
		String productId = null;
		try { 
			productId = productService.createProduct(product);
		} catch (Exception e) {
			//e.printStackTrace();
			LOGGER.error(e.getMessage(), e);

		}

		return ResponseEntity.status(HttpStatus.CREATED).body(productId);
	}

}
