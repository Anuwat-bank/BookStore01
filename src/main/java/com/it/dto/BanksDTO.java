package com.it.dto;

import java.sql.Blob;


import lombok.Data;

@Data
public class BanksDTO {
	
	private Integer bankId;
	private Integer userId;
	private String bankName;
	private String numberBank;
	private Blob qrCode;
	private String name;
	


}
