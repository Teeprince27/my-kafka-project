package com.temitope.productservice.service;


import com.temitope.productservice.dto.CreateProductRestModel;

public interface ProductService {
	
	String createProduct(CreateProductRestModel productRestModel) throws Exception ;

}
