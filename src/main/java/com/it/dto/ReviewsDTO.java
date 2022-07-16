package com.it.dto;

import lombok.Data;

@Data
public class ReviewsDTO {
	private Integer rvId;

	private Integer cId;

	private Integer userId;

	private Integer rvRank;

	private String reComment;
}
