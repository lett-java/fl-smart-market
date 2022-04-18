package com.flettieri.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.flettieri.api.enums.DocumentTypeEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "announcer")
public class Announcer extends EntityBase {

	private static final long serialVersionUID = 7336920453898544751L;

	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "document", nullable = false)
	private String document;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "document_type", nullable = false)
	private DocumentTypeEnum documentType;

}
