package com.flettieri.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flettieri.api.dto.ProductDTO;
import com.flettieri.api.model.Product;
import com.flettieri.api.repository.ProductRepository;
import com.flettieri.api.validations.ProductValidation;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductValidation productValidation;
	
	public Product save(ProductDTO productDTO) {
		productValidation.validate(productDTO);
			
		Product product = new Product();
		product.setName(productDTO.getName());
		product.setDescription(productDTO.getDescription());
		Product productSaved = productRepository.save(product);
		
		productValidation.validaOferta(productDTO, product, productSaved);
		
		return productSaved;
	}



	public List<Product> getAll() {
		return productRepository.findAll();
	}
}
