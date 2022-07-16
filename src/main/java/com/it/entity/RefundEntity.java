package com.it.entity;

import java.io.Serializable;
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
@Table(name = "tb_refund")
@AllArgsConstructor
@NoArgsConstructor
public class RefundEntity implements  Serializable {
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8141868932746279690L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rf_id")
	private Integer rfId;
	
	@Column(name = "c_id")
	private Integer cId;
	
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name = "re_id")
	private Integer reId;
	
	@Column(name = "rf_image")
	private Blob reImage;
	
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
