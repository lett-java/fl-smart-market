package com.flettieri.api.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "offer")
public class Offer extends EntityBase {

	private static final long serialVersionUID = -4038621933214934877L;
	
	@OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "announcer_id", referencedColumnName = "id", nullable = false)
	private Announcer announcer;
	
	@Column(name = "price", nullable = false)
	private BigDecimal price;
	
	@Column(name = "date")
	private LocalDate date;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "product_id", nullable = false, referencedColumnName = "id")
    private Product product;

}
