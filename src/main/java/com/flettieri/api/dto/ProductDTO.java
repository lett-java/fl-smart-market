package com.flettieri.api.dto;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {

	@ApiModelProperty(value = "Nome do produto", example = "Notebook Dell core i5", required = true)
	private String name;

	@ApiModelProperty(value = "Descrição do produto", example = "Tela 15.6 inch, 16gb de memoria Ram, processador intel Core i5, SSD m.2 de 1 Tera, cor Prata.", required = true)
	private String description;
	
	@ApiModelProperty(required = false)
	private List<OfferDTO> offers = new ArrayList<OfferDTO>();
	
}
