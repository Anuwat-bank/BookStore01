package com.it.dto;



import lombok.Data;

@Data
public class OrdersDTO {

	private Integer orderId;
	private Integer userId;
	private Integer tranSerId;
	private String recordStatus;


}
