package com.janu.myapplication.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="User")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User {
	
	    @Id                      
	    @Column(name="USER_ID")
	    @GeneratedValue(strategy=GenerationType.AUTO)
		private int userId;
	    @Column(name="USER_NAME")
		private String userName;   
	    @Column(name="PASSWORD")
	    private String password;
	    @Column(name="PHONE")
	    private String phoneNumber;
	    @Column(name="EMAILID")
	    private String emailId;
	    @Column(name="DOB")
	    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	    @JsonFormat(pattern = "YYYY-MM-dd")
	    private Date dob;
	    @Column(name="ADDRESS")
	    private String address;
	    @Column(name="POSTAL_CODE")
	    private String postalCode;
	    @Column(name="STATE")
	    private String state;
	    @Column(name="COUNTRY")
	    private String Country;
	    @Column(name="TOWN")
	    private String town;
	    @Column(name="AADHAR")
	    private String aadharNumber;
	    @Column(name="PAN")
	    private String panNumber;
	    
	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "AID")
	    private Account account;
	    
	    @JsonManagedReference
	    @OneToMany(fetch = FetchType.LAZY,
                cascade = CascadeType.ALL)
	    private Set<Beneficiary> beneficiaries;
		
	    
	    @JsonManagedReference
	    @OneToMany(fetch = FetchType.LAZY,
              cascade = CascadeType.ALL)
    	private Set<Transaction> transactions;
	    
	    

}
