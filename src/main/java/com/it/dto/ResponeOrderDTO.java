package com.it.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class ResponeOrderDTO {
	
	private Integer cId;
	private String  cName;
	private BigDecimal summaryProduct;
	private BigDecimal summaryAmount;
	private List<OrderStoreDTO> orderList;
	
	

}
