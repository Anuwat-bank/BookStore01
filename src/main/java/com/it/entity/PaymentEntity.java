package com.it.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Builder
@Data
@Table(name = "tb_payment")
@AllArgsConstructor
@NoArgsConstructor
public class PaymentEntity  implements  Serializable {
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4837039801994866546L;

	@Id
	@Column(name = "tran_sec_id")
	private Integer tranSecId;
	
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name = "bank_id")
	private Integer bankId;
	
	@Column(name = "pay_amount")
	private BigDecimal payAmount;
	
	
	@Column(name = "pay_date" )
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'" )
	private Timestamp payDate;
	
	
	@Column(name = "order_id")
	private Integer orderId;
	
	@Column(name = "track_id")
	private Integer trackId;
	
	@Column(name = "pay_image")
	private String payImage;
	
	@Column(name = "post_name")
	private String postName;
	
	@Column(name = "post_type")
	private String postType;
	
	@Column(name = "post_amount")
	private BigDecimal postAmount;
	
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
