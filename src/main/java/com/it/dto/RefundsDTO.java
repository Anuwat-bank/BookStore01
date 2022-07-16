package com.it.dto;

import java.sql.Blob;

import lombok.Data;

@Data
public class RefundsDTO {

	private Integer rfId;

	private Integer cId;

	private Integer userId;

	private Integer reId;

	private Blob reImage;

}
