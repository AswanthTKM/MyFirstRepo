package com.cts.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/* @author Anjusha*/
@Entity
@Table(name = "Userfeedback_details")
//this is pojo class of User feedback
public class UserFeedback {
	//member data
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fid;
	private int uid;
	private String ufullName;
	private String resp01;
	private String resp02;
	private String resp03;
	private String resp04;
	private String resp05;
    
	//getters and setters
	
	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUfullName() {
		return ufullName;
	}

	public void setUfullName(String ufullName) {
		this.ufullName = ufullName;
	}

	public String getResp01() {
		return resp01;
	}

	public void setResp01(String resp01) {
		this.resp01 = resp01;
	}

	public String getResp02() {
		return resp02;
	}

	public void setResp02(String resp02) {
		this.resp02 = resp02;
	}

	public String getResp03() {
		return resp03;
	}

	public void setResp03(String resp03) {
		this.resp03 = resp03;
	}

	public String getResp04() {
		return resp04;
	}

	public void setResp04(String resp04) {
		this.resp04 = resp04;
	}

	/**
	 * @param fid
	 * @param uid
	 * @param ufullName
	 * @param resp01
	 * @param resp02
	 * @param resp03
	 * @param resp04
	 */
	

	//Parameterized constructor
	public UserFeedback(int fid, int uid, String ufullName, String resp01, String resp02, String resp03, String resp04,
			String resp05) {
		super();
		this.fid = fid;
		this.uid = uid;
		this.ufullName = ufullName;
		this.resp01 = resp01;
		this.resp02 = resp02;
		this.resp03 = resp03;
		this.resp04 = resp04;
		this.resp05 = resp05;
	}

	/**
	 * 
	 */
	
	// default constructor
	
	public UserFeedback() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getResp05() {
		return resp05;
	}

	public void setResp05(String resp05) {
		this.resp05 = resp05;
	}

}
