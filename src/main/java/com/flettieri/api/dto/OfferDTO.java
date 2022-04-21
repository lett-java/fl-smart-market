package com.flettieri.api.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.flettieri.api.model.Announcer;
import com.flettieri.api.model.Product;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OfferDTO {

	@ApiModelProperty(value = "Anunciador da oferta", required = true)
	private Announcer announcer;
	
	@ApiModelProperty(value = "Preço da oferta", example = "857.64", required = true)
	private BigDecimal price;
	
	@ApiModelProperty(value = "Data da oferta", example = "2007-12-03", required = true)
	private LocalDate date;

	@ApiModelProperty(value = "Produto sendo ofertado", required = true)
    private Product product;

}
