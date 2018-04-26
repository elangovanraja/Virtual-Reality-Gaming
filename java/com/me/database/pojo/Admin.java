package com.me.database.pojo;

import javax.persistence.*;

@Entity
@Table(name="Admintable")
@PrimaryKeyJoinColumn(name="personID")
public class Admin extends Person{
	@Column(name="AdminName")
	private String AdminName;
	
	@Column(name="Password")
	private String Password;
	
	public Admin(){}
	
	public Admin(String AdminName,String Password,String firstName,String lastName){
		super(firstName,lastName);
		this.AdminName=AdminName;
		this.Password=Password;		
	}

	public String getAdminName() {
		return AdminName;
	}

	public void setAdminName(String adminName) {
		AdminName = adminName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	
	
}
