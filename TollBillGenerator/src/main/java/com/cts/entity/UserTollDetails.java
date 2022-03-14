package com.cts.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;
import lombok.*;
/* @author Nayana*/
@Getter
@Setter
@NoArgsConstructor
@Entity
//this is pojo class of UserTollDetails
public class UserTollDetails {
	
	//member data
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "uid")
	private User user;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "tid")
	private TollDetails tolldetails;
	
	private String oneortwo;
	private int price;
	private Date createdDate;
	private LocalDate JourneyDate;

	/**
	 * 
	 */
	// default constructor
	public UserTollDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//getters and setters
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public TollDetails getTolldetails() {
		return tolldetails;
	}

	public void setTolldetails(TollDetails tolldetails) {
		this.tolldetails = tolldetails;
	}

	
	
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	

	public UserTollDetails(TollDetails tolldetails, Date createdDate) {
		this.tolldetails = tolldetails;
		this.createdDate = createdDate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof UserTollDetails))
			return false;
		UserTollDetails that = (UserTollDetails) o;
		return Objects.equals(user.getUid(), that.user.getUid())
				&& Objects.equals(tolldetails.getTid(), that.tolldetails.getTid())
				&& Objects.equals(createdDate, that.createdDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(user.getUuserName(), tolldetails.getFromLocation(), tolldetails.getToLocation(),
				tolldetails.getVechtype(), tolldetails.getFee(), createdDate);
	}

	public String getOneortwo() {
		return oneortwo;
	}

	public void setOneortwo(String oneortwo) {
		this.oneortwo = oneortwo;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getJourneyDate() {
		return JourneyDate;
	}

	public void setJourneyDate(LocalDate journeyDate) {
		JourneyDate = journeyDate;
	}

	
}