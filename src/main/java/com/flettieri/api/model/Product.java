package com.flettieri.api.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product extends EntityBase {

	private static final long serialVersionUID = 4079453412034165699L;

	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "description", nullable = true)
	private String description;
	
	@OneToMany(mappedBy = "product")
	private List<Offer> offers = new ArrayList<Offer>();
	
}
