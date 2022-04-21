package com.flettieri.api.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flettieri.api.dto.ProductDTO;
import com.flettieri.api.model.Product;
import com.flettieri.api.service.OfferService;
import com.flettieri.core.exceptions.ProductDescriptionException;
import com.flettieri.core.exceptions.ProductNameException;

@Service
public class ProductValidation {
	
	@Autowired
	private OfferService offerService;

	public void validate(ProductDTO productDTO) {
		if (productDTO.getName() == null || productDTO.getName().isBlank()) {
			throw new ProductNameException("Deve passar 'name' valido.");
		}
		
		if (productDTO.getDescription() == null || productDTO.getDescription().isBlank()) {
			throw new ProductDescriptionException("Deve passar 'description' valido.");
		}
	}
	
	public void validaOferta(ProductDTO productDTO, Product product, Product productSaved) {
		if (!productDTO.getOffers().isEmpty()) {
			productDTO.getOffers().stream().forEach(offer -> {
				offer.setProduct(productSaved);
				product.getOffers().add(offerService.save(offer));
			});
		}
	}
}
