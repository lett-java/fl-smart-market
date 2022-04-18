package com.flettieri.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flettieri.api.model.Offer;
import com.flettieri.api.repository.OfferRepository;

@Service
public class OfferService {

	@Autowired
	private OfferRepository offerRepository;
	
	public Offer save(Offer offer) {
		return offerRepository.save(offer);
	}
	
}
