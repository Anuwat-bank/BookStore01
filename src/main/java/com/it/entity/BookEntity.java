package com.it.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@Table(name = "tb_book")
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3920728675850118221L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "b_id")
	private Integer bId;
	
	@Column(name ="c_id")
	private Integer cId;
	
	@Column(name ="b_name")
	private String bName;
	
	@Column(name ="b_aunthor")
	private String bAunthor;
	
	@Column(name ="cate_id")
	private Integer cateId;
	
	@Column(name ="b_price")
	private BigDecimal bPrice;
	
	@Column(name ="b_desc")
	private String bDesc;
	
	@Column(name ="b_image")
	private Blob bImage;
	
	@Column(name = "b_stock")
	private String bStock;
	
	@Column(name="record_status")
    private String recordStatus;
	
	@Column(name="creat_by")
    private String creatBy;
	
	@CreationTimestamp
	@Column(name="creat_date" , nullable = false , updatable = false)
    private Timestamp creatDate;
	
	@Column(name="update_by")
    private String updateBy;
	
	@UpdateTimestamp
	@Column(name="update_date")
    private Timestamp updateDate;
	
	
	
	
}
