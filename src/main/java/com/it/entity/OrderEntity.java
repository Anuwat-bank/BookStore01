package com.it.entity;

import java.io.Serializable;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "tb_order")
public class OrderEntity  {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id")
	private Integer orderId;
	
	@Column(name = "c_id")
	private Integer cId;
	
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name = "tran_sec_id")
	private Integer tranSecId;
	
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
	
	@OneToMany()
	@JoinColumn(name = "order_id")
	private List<OrderDetailEntity> orderDetail;
	
	
	
	
	
	

}
