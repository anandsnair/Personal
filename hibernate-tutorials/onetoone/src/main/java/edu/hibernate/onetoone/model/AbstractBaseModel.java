package edu.hibernate.onetoone.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

import org.springframework.data.domain.Persistable;

@MappedSuperclass
public class AbstractBaseModel implements Persistable<String>{
	@Id
	@Column(name="ID")
	private String id;
	@Column(name="CREATED_TIME")
	private Date createdTime;
	
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String getId() {
		return id;
	}
	@Override
	public boolean isNew() {
		return null == getId();
	}
	
	@PrePersist
	protected void onCreate() {
		if (getId() == null) {
			setId(UUID.randomUUID().toString());
			createdTime = new Date();
			setCreatedTime(createdTime);
		}		
	}

}
