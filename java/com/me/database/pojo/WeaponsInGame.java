package com.me.database.pojo;

import javax.persistence.*;
@Entity
@Table(name="WIG_WEAPONS_GAME")
@SequenceGenerator(name="seq", initialValue=1, allocationSize=1000)
public class WeaponsInGame {

	public WeaponsInGame(){}
	public WeaponsInGame(int participantId,int weaponId,int ammo,int actualId){
		this.ammo=ammo;
		this.participantId=participantId;this.weaponId=weaponId;
		this.actualId=actualId;
		//this.actualId=(participantId%8)+1;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	@Column(name="WIG_WEAPONS_GAME_TABLE_ID", nullable=false, unique=true)
	private int id;
	
	private int participantId;
	
	@Column(name="WIG_WEAPONS_GAME_ID")
	private int actualId;
	
	private int weaponId;
	
	@Column(name="WIG_AMMO_LEFT")
	private int ammo;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getActualId() {
		return actualId;
	}
	public void setActualId(int actualId) {
		this.actualId = actualId;
	}
	public int getAmmo() {
		return ammo;
	}
	public void setAmmo(int ammo) {
		this.ammo = ammo;
	}
	public int getParticipantId() {
		return participantId;
	}
	
	public void setParticipantId(int participantId) {
		this.participantId = participantId;
	}
	
	public int getWeaponId() {
		return weaponId;
	}
	
	public void setWeaponId(int weaponId) {
		this.weaponId = weaponId;
	}
	
}
