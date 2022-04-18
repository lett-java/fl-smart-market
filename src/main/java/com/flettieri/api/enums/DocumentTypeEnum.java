package com.flettieri.api.enums;

import lombok.Getter;

@Getter
public enum DocumentTypeEnum {

	CNPJ("CNPJ"),
	CPF("CPF");
	
	private String description;
	
	DocumentTypeEnum(String description) {
		this.description = description;
	}
	
}
