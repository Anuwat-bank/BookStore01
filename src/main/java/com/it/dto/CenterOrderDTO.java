package com.it.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CenterOrderDTO {
	
	private Integer orderId;
	private Integer cId;
	private Integer bId;
	private String bName;
	private Integer orderNumber;
	private BigDecimal orderAmount;
	private Integer userId;
	private Integer tranSecId;
	private String recordStatus;
	private PaymentsDTO paymentsDTO;
}
