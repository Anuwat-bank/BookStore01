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

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@Table(name = "tb_reason")
@AllArgsConstructor
@NoArgsConstructor
public class ReasonEntity implements  Serializable {
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6939740380279929321L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "re_id")
	private Integer reId;

	
	@Column(name = "re_desc")
	private String reDesc;
	
	@Column(name = "re_type")
	private String reType;
	
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
