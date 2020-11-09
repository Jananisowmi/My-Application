package com.janu.myapplication.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="account")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonIgnore
	@Column(name="AID")
	private int aId;
	@Column(name="ACCOUNT_NUMBER")
	private String accountNumber;
    @Column(name="IFSC")
	private String ifscCode;
	@Column(name="BRANCH")
	private String branch;
	@Column(name="BANKNAME")
	private String bankName;
	@Column(name="BALANCE")
	private Double balance;
	
	 @OneToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name = "USER_ID")
	 private User user;
	    
//	@OneToMany(fetch = FetchType.LAZY,
//                 cascade = CascadeType.ALL)
//	private Set<Beneficiary> beneficiaries;
	
}
