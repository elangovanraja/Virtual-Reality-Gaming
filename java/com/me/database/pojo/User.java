package com.me.database.pojo;
import javax.persistence.*;
@Entity
@Table(name="usertable")
@PrimaryKeyJoinColumn(name="personID")
public class User extends Person{
	@Column(name=" userName")
	private String userName;
	
	@Column(name=" Password")
	private String Password;
	
	public User(){
	}
	
	public User(String userName, String Password,String firstName,String lastName){
		super(firstName,lastName);
		this.userName=userName;
		this.Password=Password;
		
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
}
