package com.temitope.productservice.service;


import com.temitope.productservice.dto.CreateProductRequestDto;

public interface ProductService {
	
	String createProduct(CreateProductRequestDto productRestModel) throws Exception ;

}
