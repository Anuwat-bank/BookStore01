package com.it.entity;

import java.io.Serializable;

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
@Table(name = "tb_catagory")
@AllArgsConstructor
@NoArgsConstructor
public class CatagoryEntity implements  Serializable {

	private static final long serialVersionUID = 3716952508670694939L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cate_id")
	private Integer cateId;
	
	@Column(name = "bate_pro_name")
	private String bateProName;
	
	@Column(name = "bate_pro_desc")
	private String  bateProDesc;
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
