package com.flettieri.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flettieri.api.dto.OfferDTO;
import com.flettieri.api.model.Offer;
import com.flettieri.api.repository.OfferRepository;
import com.flettieri.api.validations.OfferValidation;

@Service
public class OfferService {

	@Autowired
	private OfferRepository offerRepository;
	
	@Autowired
	private OfferValidation offerValidation;
	
	public Offer save(OfferDTO offerDTO) {
		offerValidation.validate(offerDTO);
		
		Offer offer = new Offer();
		offer.setAnnouncer(offerDTO.getAnnouncer());
		offer.setDate(offerDTO.getDate());
		offer.setPrice(offerDTO.getPrice());
		offer.setProduct(offerDTO.getProduct());
		
		return offerRepository.save(offer);
	}
}
