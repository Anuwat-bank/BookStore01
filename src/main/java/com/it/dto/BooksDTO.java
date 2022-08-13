package com.it.dto;

import java.math.BigDecimal;
import java.sql.Blob;

import lombok.Data;

@Data
public class BooksDTO {

	private Integer bId;

	private Integer cId;

	private String bName;

	private String bAunthor;

	private Integer cateId;
	
	private String bDesc;

	private BigDecimal bPrice;

	private String bImage;

	private String bStock;

}
