package com.temitope.productservice.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateProductRequestDto {
	private String title;
	private BigDecimal price;
	private Integer quantity;
}
