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
@Table(name = "tb_user_detail")
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailEntity implements Serializable {

	 
	 /**
	 * 
	 */
	private static final long serialVersionUID = -1803941271547665007L;

	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 @Column(name = "user_detail_id")
	 private Integer userDetailId;
	 
	 @Column(name = "username" )
	 private String username;
	 
	 @Column(name = "frist_name")
	 private String fristName;
	 
	 @Column(name = "last_name")
	 private String lastName;
	 
	 @Column(name = "c_name")
	 private String cName;
	 
	 @Column(name = "c_document")
	 private Blob cDocument;
	 
	 @Column(name = "gender")
	 private String gender;
	 
	 @Column(name = "birthday")
	 private String birthday;
	 
	 @Column(name = "user_address")
	 private String userAddress;
	 
	 @Column(name = "user_zib_id")
	 private String userZibId;
	 
	 @Column(name = "tcode")
	 private Integer tcode;
	 
	 @Column(name = "acode")
	 private Integer acode;
	 
	 @Column(name = "pcode")
	 private Integer pcode;
	 
	 @Column(name = "user_phone")
	 private Integer userPhone;
	 
	 @Column(name = "user_email")
	 private String userEmail;
	 
	 @Column(name = "user_imege")
	 private Blob userImege;
	 
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
