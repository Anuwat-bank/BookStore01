package com.it.dto;

import java.sql.Blob;

import lombok.Data;

@Data
public class UserDetailsDTO {

	private Integer userDetailId;

	private String username;

	private String fristName;

	private String lastName;

	private String cName;

	private Blob cDocument;

	private String gender;

	private String birthday;

	private String userAddress;

	private String userZibId;

	private Integer tcode;

	private Integer acode;

	private Integer pcode;

	private Integer userPhone;

	private String userEmail;

	private Blob userImege;

}
