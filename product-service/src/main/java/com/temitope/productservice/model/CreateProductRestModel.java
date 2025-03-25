package com.temitope.productservice.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
@Table(name = "products")
public class CreateProductRestModel {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String productId;
	private String title;
	private BigDecimal price;
	private Integer quantity;
}
