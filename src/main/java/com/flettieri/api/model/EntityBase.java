package com.flettieri.api.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@MappedSuperclass
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class EntityBase implements Serializable {

	private static final long serialVersionUID = 4531707869595283646L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "created_date")
	private LocalDateTime createdDate;
	
	@Column(name = "updated_date")
	private LocalDateTime updatedDate;
	
	@Column(name = "disabled_date")
	private LocalDateTime disabledDate;
	
	@Column(name = "enabled")
	private boolean enabled;
	
	
	@PrePersist 
	public void persist() {
		this.createdDate = LocalDateTime.now();
		this.enabled = true;
	}
}
