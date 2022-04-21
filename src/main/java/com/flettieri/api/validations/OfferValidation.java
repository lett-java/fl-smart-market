package com.flettieri.api.validations;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.flettieri.api.dto.OfferDTO;
import com.flettieri.core.exceptions.AnnouncerException;
import com.flettieri.core.exceptions.OfferDateException;
import com.flettieri.core.exceptions.OfferPriceException;
import com.flettieri.core.exceptions.OfferProductException;

@Service
public class OfferValidation {

	public void validate(OfferDTO offerDTO) {
		if (offerDTO.getAnnouncer() == null || offerDTO.getAnnouncer().getId() == null) {
			throw new AnnouncerException("Deve passar 'announcer' valido.");
		}
		
		if (offerDTO.getDate() == null) {
			throw new OfferDateException("Deve passar 'date' valido.");
		}
		
		if (offerDTO.getPrice() == null || offerDTO.getPrice() == BigDecimal.ZERO) {
			throw new OfferPriceException("Deve passar 'price' valido ou maior que ZERO");
		}
		
		if (offerDTO.getProduct() == null || offerDTO.getProduct().getId() == null) {
			throw new OfferProductException("Deve passar 'product' valido.");
		}
	}
}
