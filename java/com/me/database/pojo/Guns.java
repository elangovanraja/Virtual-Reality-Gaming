package com.me.database.pojo;

import javax.persistence.*;

@Entity
@Table(name="GUN_GUNS")
@PrimaryKeyJoinColumn(name="GUN_WEAPON_ID")
public class Guns extends Weapons {
	public Guns(){}
	public Guns(int weaponId,int gameId,String weaponName,String weaponType,String description,int mass,int velocity,int no){
		super(weaponId,gameId,weaponName,weaponType,description);
		this.mass=mass;
		this.velocity=velocity;
		this.numberOfBullets=no;		
	}
	
	
	@Column(name="VIB_LVL", columnDefinition="int default '0'")
	private int vib_lvl;
	
	public int getVib_lvl() {
		return vib_lvl;
	}

	public void setVib_lvl(int vib_lvl) {
		this.vib_lvl = vib_lvl;
	}
	
	@Column(name="GUN_DESC")
	private String desc;
	
	@Column(name="GUN_MASS")
	private int mass;
	
	@Column(name="GUN_VEL")
	private int velocity;
	
	@Column(name="GUN_NUMBER_OF_BULLETS")
	private int numberOfBullets;

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getMass() {
		return mass;
	}

	public void setMass(int mass) {
		this.mass = mass;
	}

	public int getVelocity() {
		return velocity;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	public int getNumberOfBullets() {
		return numberOfBullets;
	}

	public void setNumberOfBullets(int numberOfBullets) {
		this.numberOfBullets = numberOfBullets;
	}
	
}
