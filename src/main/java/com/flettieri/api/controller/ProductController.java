package com.flettieri.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flettieri.api.model.Product;
import com.flettieri.api.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/save")
	public ResponseEntity<Product> save(@RequestBody Product product) {
		return ResponseEntity.ok().body(productService.save(product));
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Product>> getAll() {
		return ResponseEntity.ok().body(productService.getAll());
	}
	
}
