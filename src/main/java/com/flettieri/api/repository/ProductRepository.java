package com.flettieri.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flettieri.api.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
}
