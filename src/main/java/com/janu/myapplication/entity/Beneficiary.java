package com.janu.myapplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="beneficiary")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Beneficiary {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonIgnore
    @Column(name="BID")
	private int bid; 
	@Column(name="ACC_NO")
	private String accNo;
	@Column(name="BEN_NAME")
	private String benName;
	@Column(name="IFSC_CODE")
	private String ifscCode;
	@Column(name="BANK_NAME")
	private String bankName;
	
	
	/*
	 * @ManyToOne(targetEntity= Account.class,fetch = FetchType.LAZY, optional =
	 * false)
	 * 
	 * @JoinColumn(name = "AID") private Account account;
	 */
	
	@JsonBackReference
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(targetEntity= User.class,fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "USER_ID")
    private User user;
    
    
	

}
