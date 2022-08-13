package com.it.dto;



import com.ibm.icu.math.BigDecimal;

import lombok.Data;

@Data
public class OrdersDTO {

	private Integer orderId;
	private Integer userId;
	private Integer tranSecId;
	private String recordStatus;
	private Integer  cId;
	private Integer	bId ;
	private Integer	orderNumber; 
	private BigDecimal	orderAmount; 
	


}
