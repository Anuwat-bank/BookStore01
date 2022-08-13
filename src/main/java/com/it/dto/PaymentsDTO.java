package com.it.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Timestamp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.it.utils.TimestampSerializer;

import lombok.Data;

@Data
public class PaymentsDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 302572114021294377L;

	private Integer tranSecId;

	private Integer userId;

	private Integer bankId;

	private BigDecimal payAmount;
	@JsonSerialize(using = TimestampSerializer.class)
	private Timestamp payDate;

	private Integer orderId;

	private Integer trackId;

	private String payImage;

	private String postName;

	private String postType;

	private BigDecimal postAmount;
	
	private String recordStatus;

}
