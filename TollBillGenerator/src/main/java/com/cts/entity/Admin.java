package com.cts.entity;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
    
  /* @author Anjusha*/

@Entity
@Table(name = "admin_details")
//this is pojo class of admin
public class Admin {
	
    //member data
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aid;
	private String aemail;
	private String auserName;
	private String apassword;

	
	//getters and setters
	
	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAemail() {
		return aemail;
	}

	public void setAemail(String aemail) {
		this.aemail = aemail;
	}

	public String getAuserName() {
		return auserName;
	}

	public void setAuserName(String auserName) {
		this.auserName = auserName;
	}

	public String getApassword() {
		return apassword;
	}

	public void setApassword(String apassword) {
		this.apassword = apassword;
	}

	/**
	 * 
	 */// default constructor
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param aid
	 * @param aemail
	 * @param auserName
	 * @param apassword
	 */
	//Parameterized constructor
	public Admin(int aid, String aemail, String auserName, String apassword) {
		super();
		this.aid = aid;
		this.aemail = aemail;
		this.auserName = auserName;
		this.apassword = apassword;
	}

}
