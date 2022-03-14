package com.cts.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

import lombok.Data;
/* @author Sachin*/
@Entity
@Table(name = "user_details", uniqueConstraints = { @UniqueConstraint(columnNames = "uemail") })
//this is pojo class of User
 public class User {
	//member data
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uid;

	@NotBlank(message = "* Fullname cannot be blank")
	@Length(min = 3, message = "* Fullname must have atleast 3 characters")
	@Pattern(regexp = "[A-z|\\s]+", message = "* Fullname should be alphabet only")
	private String ufullName;

	@NotBlank(message = "* Age cannot be blank")
	@Pattern(regexp = "^(1[9]|[2-9][0-9])$", message = "* Age must be between 19 and 99")
	private String uage;

	@NotBlank(message = "* Address cannot be blank")
	@Length(min = 4, message = "* Address must have atleast 4 characters")
	private String uaddress;

	@NotBlank(message = "* Email cannot be blank")
	@Email(message = "* Email must be well-formated")
	@Column(unique = true)
	private String uemail;

	@NotBlank(message = "* Username cannot be blank")
	@Length(min = 4, message = "* Username must have atleast 4 characters")
	private String uuserName;
	
	private String uvtype;
	private String uvNumber;

	@NotBlank(message = "* Password cannot be blank")
	@Length(min = 4, message = "* Password must have atleast 4 characters")
	@Pattern(regexp = "^(?=.{6,})(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+*!=]).*$", message = "* Password should contain atleast 1 uppercase, 1 lowercase and 1 special character")
	private String upassword;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<UserTollDetails> userTolldetails;
    
	
	//getters and setters
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

	public String getUage() {
		return uage;
	}

	public void setUage(String uage) {
		this.uage = uage;
	}

	public String getUaddress() {
		return uaddress;
	}

	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public String getUuserName() {
		return uuserName;
	}

	public void setUuserName(String uuserName) {
		this.uuserName = uuserName;
	}

	public String getUpassword() {
		return upassword;
	}

	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}

	public Set<UserTollDetails> getUserTolldetails() {
		return userTolldetails;
	}

	public void setUserTolldetails(Set<UserTollDetails> userTolldetails) {
		this.userTolldetails = userTolldetails;
	}

	public String getUvtype() {
		return uvtype;
	}

	public void setUvtype(String uvtype) {
		this.uvtype = uvtype;
	}

	public String getUvNumber() {
		return uvNumber;
	}

	public void setUvNumber(String uvNumber) {
		this.uvNumber = uvNumber;
	}

	/**
	 * @param uid
	 * @param ufullName
	 * @param uage
	 * @param uaddress
	 * @param uemail
	 * @param uuserName
	 * @param upassword
	 * @param userTolldetails
	 */
	
	//Parameterized constructor
	public User(int uid,
			String uvtype,
			String uvNumber,
			@NotBlank(message = "* Fullname cannot be blank") @Length(min = 3, message = "* Fullname must have atleast 3 characters") @Pattern(regexp = "[A-z|\\s]+", message = "* Fullname should be alphabet only") String ufullName,
			@NotBlank(message = "* Age cannot be blank") @Pattern(regexp = "^(1[9]|[2-9][0-9])$", message = "* Age must be between 19 and 99") String uage,
			@NotBlank(message = "* Address cannot be blank") @Length(min = 4, message = "* Address must have atleast 4 characters") String uaddress,
			@NotBlank(message = "* Email cannot be blank") @Email(message = "* Email must be well-formated") String uemail,
			@NotBlank(message = "* Username cannot be blank") @Length(min = 4, message = "* Username must have atleast 4 characters") String uuserName,
			@NotBlank(message = "* Password cannot be blank") @Length(min = 4, message = "* Password must have atleast 4 characters") @Pattern(regexp = "^(?=.{6,})(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+*!=]).*$", message = "* Password should contain atleast 1 uppercase, 1 lowercase and 1 special character") String upassword,
			Set<UserTollDetails> userTolldetails) {
		super();
		this.uid = uid;
		this.ufullName = ufullName;
		this.uage = uage;
		this.uaddress = uaddress;
		this.uemail = uemail;
		this.uuserName = uuserName;
		this.upassword = upassword;
		this.uvtype = uvtype;
		this.uvNumber = uvNumber;
		
		for(UserTollDetails userTolldetails : userTolldetails) userTolldetails.setUser(this);
        this.userTolldetails = Stream.of(userTolldetails).collect(Collectors.toSet());
	}

	/**
	 * 
	 */
	// default constructor
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

}