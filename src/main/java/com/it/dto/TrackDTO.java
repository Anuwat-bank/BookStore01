package com.it.dto;

import java.sql.Blob;

import lombok.Data;

@Data
public class TrackDTO {
	private Integer trackId;

	private Integer userId;

	private Integer cId;

	private String trackDesc;

	private Blob trackImage;

}
