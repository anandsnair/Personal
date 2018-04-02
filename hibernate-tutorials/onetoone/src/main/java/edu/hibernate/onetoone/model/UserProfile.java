package edu.hibernate.onetoone.model;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="USER_PROFILE")
public class UserProfile extends AbstractBaseModel {
	
	@Column(name="PHONE_NUMBER")
	@Size(max=15)
	private String phoneNumber;
	@Column(name="EMAIL")
	@Size(max=100)
	private String emailId;
	
	@AttributeOverrides({
		@AttributeOverride(name="firstLine", column= @Column(name="HOME_ADDR_FIRST_LINE")),
		@AttributeOverride(name="secondLine", column= @Column(name="HOME_ADDR_SECOND_LINE")),
		@AttributeOverride(name="city", column= @Column(name="HOME_ADDR_CITY")),
		@AttributeOverride(name="state", column= @Column(name="HOME_STATE_CITY")),
		@AttributeOverride(name="country", column= @Column(name="HOME_ADDR_COUNTRY")),
		@AttributeOverride(name="zipCode", column= @Column(name="HOME_ADDR_ZIPCODE"))
	})
	private Address homeAddress;
	@AttributeOverrides({
		@AttributeOverride(name="firstLine", column= @Column(name="WORK_ADDR_FIRST_LINE")),
		@AttributeOverride(name="secondLine", column= @Column(name="WORK_ADDR_SECOND_LINE")),
		@AttributeOverride(name="city", column= @Column(name="WORK_ADDR_CITY")),
		@AttributeOverride(name="state", column= @Column(name="WORK_STATE_CITY")),
		@AttributeOverride(name="country", column= @Column(name="WORK_ADDR_COUNTRY")),
		@AttributeOverride(name="zipCode", column= @Column(name="WORK_ADDR_ZIPCODE"))
	})
	private Address officeAddress;
	
	@Column(name="DATE_OF_BIRTH")
	private Date dateOfBirth;
	@OneToOne
	private User user;
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
