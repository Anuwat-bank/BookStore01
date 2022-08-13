package com.it.dto;



import java.math.BigDecimal;

import lombok.Data;

@Data
public class OrderStoreDTO {
	private Integer orderId;
	private Integer bId;
	private Integer cId;
	private String bName;
	private Integer	orderNumber; 
	private BigDecimal	orderAmount; 
	

}
