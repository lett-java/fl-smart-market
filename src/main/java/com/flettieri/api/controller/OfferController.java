package com.flettieri.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flettieri.api.dto.OfferDTO;
import com.flettieri.api.model.Offer;
import com.flettieri.api.service.OfferService;

@RestController
@RequestMapping("/offer")
public class OfferController {

	@Autowired
	private OfferService offerService;
	
	@PostMapping("/save")
	public ResponseEntity<Offer> save(@RequestBody OfferDTO offerDTO) {
		return ResponseEntity.ok().body(offerService.save(offerDTO));
	}
	
}
