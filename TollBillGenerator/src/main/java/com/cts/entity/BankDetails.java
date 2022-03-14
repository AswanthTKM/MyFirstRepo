package com.cts.entity;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/* @author Nayana*/

@Entity
@Table(name = "bank_details")
//this is a pojo class of bank details
public class BankDetails {
   //member data
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bid;
	private String buserName;
	private String bpassword;
	private int balanceAmount;

	
	//getters and setters
	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBuserName() {
		return buserName;
	}

	public void setBuserName(String buserName) {
		this.buserName = buserName;
	}

	public String getBpassword() {
		return bpassword;
	}

	public void setBpassword(String bpassword) {
		this.bpassword = bpassword;
	}

	public int getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(int balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	/**
	 * 
	 *///default constructor
	public BankDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param bid
	 * @param buserName
	 * @param bpassword
	 * @param balanceAmount
	 */
	
	//Parameterized constructor
	
	public BankDetails(int bid, String buserName, String bpassword, int balanceAmount) {
		super();
		this.bid = bid;
		this.buserName = buserName;
		this.bpassword = bpassword;
		this.balanceAmount = balanceAmount;
	}

}
