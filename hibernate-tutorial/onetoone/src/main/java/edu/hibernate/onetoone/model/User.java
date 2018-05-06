package edu.hibernate.onetoone.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="USER")
public class User extends AbstractBaseModel {

	
	private Name name;
	@Column(name="USERNAME",nullable=false)
	private String username;
	@Column(name="PASSWORD",nullable=false)
	private String password;
	
	@OneToOne(mappedBy="user", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private UserProfile userProfile;

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
	
	
}
