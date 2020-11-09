package com.janu.myapplication.entity;

import java.util.Date;

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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="transaction")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonIgnore
    @Column(name="TID")
	private int tId;
	@Column(name="TRANS_ID")
	private String transId;
	@Column(name="TIMESTAMP")
	private Date timeStamp;
    @Column(name="AMOUNT")
	private Double amount;
	@Column(name="COMMENT")
	private String comment;
	@Column(name="TYPE")
	private String type;
	@Column(name="BENEFICIARY_ACCOUNT")
	private String beneficiaryAccount;
    @Column(name="BEN_NAME")
	private String benName;
    @Column(name="FROM_ACCOUNT")
    private String fromAccount;
	
    @JsonBackReference
    @ManyToOne(targetEntity= User.class,fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "USER_ID")
    private User user;
    

}
