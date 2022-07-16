package com.it.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "tb_order_detail")
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailEntity implements  Serializable {
	

	
	private static final long serialVersionUID = -8552384872713777102L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_detail_id")
	private Integer orderDetailId;
	
	
	@Column(name = "order_id")
	private Integer orderId;
	
	@Column(name = "c_id")
	private Integer cId;
	
	@Column(name = "b_id")
	private Integer bId;
	
	@Column(name = "order_number")
	private String orderNumber;
	
	@Column(name = "order_amount")
	private BigDecimal orderAmount;
	

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
