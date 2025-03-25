package com.temitope.productservice.dao;


import com.temitope.productservice.model.CreateProductRestModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<CreateProductRestModel, String > {


}
