package com.it.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "tb_book")
public class BookEntity  {

	

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
	private String bImage;
	
	@Column(name = "b_stock")
	private String bStock;
	
	@Column(name="record_status")
    private String recordStatus;
	
	@Column(name="creat_by")
    private String creatBy;
	@CreationTimestamp
	@Column(name="creat_date" , nullable = false , updatable = false)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'" )
    private Timestamp creatDate;
	
	@Column(name="update_by")
    private String updateBy;
	
	@UpdateTimestamp
	@Column(name="update_date")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'" )
    private Timestamp updateDate;
	
	
}
