package com.me.database.pojo;

import javax.persistence.*;

@Entity
@Table(name="RCK_ROCKET_LAUNCHER")
@PrimaryKeyJoinColumn(name="RCK_WEAPON_ID")

public class RocketLauncher extends Weapons {
	
	public RocketLauncher(){}
	

	public RocketLauncher(int weaponId,int gameId,String weaponName,String weaponType,String description,int velocity,int no){
		super(weaponId,gameId,weaponName,weaponType,description);
		this.vel=velocity;
		this.numberOfRockets=no;
		
	}
	
	
	
	@Column(name="VIB_LVL", columnDefinition="int default '0'")
	private int vib_lvl;
	
	public int getVib_lvl() {
		return vib_lvl;
	}

	public void setVib_lvl(int vib_lvl) {
		this.vib_lvl = vib_lvl;
	}
	@Column(name="RCK_DESC")
	private String description;

	@Column(name="RCK_VEL")
	private int vel;
	
	@Column(name="RCK_NM_OF_RCKTS")
	private int numberOfRockets;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getVel() {
		return vel;
	}

	public void setVel(int vel) {
		this.vel = vel;
	}

	public int getNumberOfRockets() {
		return numberOfRockets;
	}

	public void setNumberOfRockets(int numberOfRockets) {
		this.numberOfRockets = numberOfRockets;
	}
	
	
}
