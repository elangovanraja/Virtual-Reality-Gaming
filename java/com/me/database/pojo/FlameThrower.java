package com.me.database.pojo;

import javax.persistence.*;

@Entity
@Table(name="FLM_FLAME_THROWER")
@PrimaryKeyJoinColumn(name="FLM_WEAPON_ID")

public class FlameThrower extends Weapons {
	public FlameThrower(){}
	
	public FlameThrower(int weaponId,int gameId,String weaponName,String weaponType,String description,int mass,int velocity,int no){
		super(weaponId,gameId,weaponName,weaponType,description);
		this.ammo=no;
		this.intensity=mass;
		this.temperature=velocity;		
	}
	
	
	@Column(name="VIB_LVL", columnDefinition="int default '0'")
	private int vib_lvl;
	
	public int getVib_lvl() {
		return vib_lvl;
	}

	public void setVib_lvl(int vib_lvl) {
		this.vib_lvl = vib_lvl;
	}
	@Column(name="AMMO")
	private int ammo;
	
	public int getAmmo() {
		return ammo;
	}

	public void setAmmo(int ammo) {
		this.ammo = ammo;
	}
	@Column(name="FLM_DESC")
	private String desc;
	
	@Column(name="FLM_INTENSITY")
	private int intensity;
	
	@Column(name="FLM_TEMP")
	private int temperature;

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getIntensity() {
		return intensity;
	}

	public void setIntensity(int intensity) {
		this.intensity = intensity;
	}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	
}
