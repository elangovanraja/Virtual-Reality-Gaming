package com.me.database.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="person")
@Inheritance(strategy=InheritanceType.JOINED)
public class Person {
	@Column(name="firstName")
	private String firstName;
	
	public Person(){}
	public Person(String firstName,String lastName){
		this.firstName=firstName;
		this.lastName=lastName;
		
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Column(name="lastName")
	private String lastName;
	
	@Id
	@GeneratedValue
	@Column(name="personId",unique=true,nullable=false)
	private long ID;
	
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public long getID() {
		return ID;
	}
	public void setID(long ID) {
		this.ID = ID;
	}
	
	
}
