package com.flettieri.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flettieri.api.model.Offer;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

}
