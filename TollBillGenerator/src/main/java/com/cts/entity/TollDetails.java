package com.cts.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/*@Author Fazil*/
@Entity
@Table(name = "toll_details")
//this is pojo class of tolldetails
public class TollDetails {
	//member data
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tid;
	private String fromLocation;
	private String toLocation;
	private String vechtype;
	private int fee;
	private String tapproval;
	//getters and setters
	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getFromLocation() {
		return fromLocation;
	}

	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}

	public String getToLocation() {
		return toLocation;
	}

	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}

	public String getVechtype() {
		return vechtype;
	}

	public void setVechtype(String vechtype) {
		this.vechtype = vechtype;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public String getTapproval() {
		return tapproval;
	}

	public void setTapproval(String tapproval) {
		this.tapproval = tapproval;
	}

	/**
	 * @param tid
	 * @param fromLocation
	 * @param toLocation
	 * @param vechtype
	 * @param fee
	 * @param tapproval
	 */
	//Parameterized constructor
	public TollDetails(int tid, String fromLocation, String toLocation, String vechtype, int fee, String tapproval) {
		super();
		this.tid = tid;
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		this.vechtype = vechtype;
		this.fee = fee;
		this.tapproval = tapproval;
	}

	/**
	 * 
	 */
	// default constructor
	public TollDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

}
