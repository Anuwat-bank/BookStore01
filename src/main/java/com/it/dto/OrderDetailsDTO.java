package com.it.dto;

import java.math.BigDecimal;



import lombok.Data;

@Data
public class OrderDetailsDTO {

	private Integer orderDetailId;

	private Integer orderId;

	private Integer cId;

	private Integer bId;

	private String orderNumber;

	private BigDecimal orderAmount;

}
