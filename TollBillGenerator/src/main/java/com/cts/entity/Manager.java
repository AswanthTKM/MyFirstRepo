package com.cts.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
/*@Author Rasheem*/
@Entity
@Table(name = "manager_details", uniqueConstraints = { @UniqueConstraint(columnNames = "memail") })
//this is a pojo class of manager
public class Manager {
    //member data
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mid;

	@NotBlank(message = "* Fullname cannot be blank")
	@Length(min = 3, message = "* Fullname must have atleast 3 characters")
	@Pattern(regexp = "[A-z|\\s]+", message = "* Fullname should be alphabet only")
	private String mfullName;

	@NotBlank(message = "* Age cannot be blank")
	@Pattern(regexp = "^(1[9]|[2-9][0-9])$", message = "* Age must be between 19 and 99")
	private String mage;

	private String mapproval;

	@NotBlank(message = "* Email cannot be blank")
	@Email(message = "* Email must be well-formated")
	@Column(unique = true)
	private String memail;

	@NotBlank(message = "* Date of birth cannot be blank")
	@Pattern(regexp = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$",message = "* date of birth should in any of these formats dd/mm/yyyy, dd-mm-yyyy or dd.mm.yyyy")
	private String mDOB;

	@NotBlank(message = "* Gender cannot be blank")
	private String mgender;

	@NotBlank(message = "* Contact number cannot be blank")
	@Pattern(regexp = "[7-9][0-9]{9}", message = "* Contact number should be a number of 10 digits, and start with 7/8/9")
	private String mcontactnum;

	@NotBlank(message = "* Username cannot be blank")
	@Length(min = 4, message = "* Username must have atleast 4 characters")
	private String muserName;

	@NotBlank(message = "* Password cannot be blank")
	@Length(min = 4, message = "* Password must have atleast 4 characters")
	@Pattern(regexp = "^(?=.{6,})(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+*!=]).*$", message = "* Password should contain atleast 1 uppercase, 1 lowercase and 1 special character")
	private String mpassword;
    
	//getters and setters
	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getMfullName() {
		return mfullName;
	}

	public void setMfullName(String mfullName) {
		this.mfullName = mfullName;
	}

	public String getMage() {
		return mage;
	}

	public void setMage(String mage) {
		this.mage = mage;
	}

	public String getMapproval() {
		return mapproval;
	}

	public void setMapproval(String mapproval) {
		this.mapproval = mapproval;
	}

	public String getMemail() {
		return memail;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	public String getMuserName() {
		return muserName;
	}

	public void setMuserName(String muserName) {
		this.muserName = muserName;
	}

	public String getMpassword() {
		return mpassword;
	}

	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}

	public String getmDOB() {
		return mDOB;
	}

	public void setmDOB(String mDOB) {
		this.mDOB = mDOB;
	}

	public String getMgender() {
		return mgender;
	}

	public void setMgender(String mgender) {
		this.mgender = mgender;
	}

	public String getMcontactnum() {
		return mcontactnum;
	}

	public void setMcontactnum(String mcontactnum) {
		this.mcontactnum = mcontactnum;
	}

	/**
	 * 
	 */
	//default constructor
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param mid
	 * @param mfullName
	 * @param mage
	 * @param mapproval
	 * @param memail
	 * @param mDOB
	 * @param mgender
	 * @param mcontactnum
	 * @param muserName
	 * @param mpassword
	 */
	//Parameterized constructor
	public Manager(int mid,
			@NotBlank(message = "* Fullname cannot be blank") @Length(min = 3, message = "* Fullname must have atleast 3 characters") @Pattern(regexp = "[A-z|\\s]+", message = "* Fullname should be alphabet only") String mfullName,
			@NotBlank(message = "* Age cannot be blank") @Pattern(regexp = "^(1[9]|[2-9][0-9])$", message = "* Age must be between 19 and 99") String mage,
			String mapproval,
			@NotBlank(message = "* Email cannot be blank") @Email(message = "* Email must be well-formated") String memail,
			@NotBlank(message = "* Date of birth cannot be blank") @Pattern(regexp = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$", message = "* date of birth should in any of these formats dd/mm/yyyy, dd-mm-yyyy or dd.mm.yyyy") String mDOB,
			@NotBlank(message = "* Gender cannot be blank") String mgender,
			@NotBlank(message = "* Contact number cannot be blank") @Pattern(regexp = "[7-9][0-9]{​​​​​​​9}​​​​​​​", message = "* Contact number should be a number of 10 digits, and start with 7/8/9") String mcontactnum,
			@NotBlank(message = "* Username cannot be blank") @Length(min = 4, message = "* Username must have atleast 4 characters") String muserName,
			@NotBlank(message = "* Password cannot be blank") @Length(min = 4, message = "* Password must have atleast 4 characters") @Pattern(regexp = "^(?=.{6,})(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+*!=]).*$", message = "* Password should contain atleast 1 uppercase, 1 lowercase and 1 special character") String mpassword) {
		super();
		this.mid = mid;
		this.mfullName = mfullName;
		this.mage = mage;
		this.mapproval = mapproval;
		this.memail = memail;
		this.mDOB = mDOB;
		this.mgender = mgender;
		this.mcontactnum = mcontactnum;
		this.muserName = muserName;
		this.mpassword = mpassword;
	}

}
