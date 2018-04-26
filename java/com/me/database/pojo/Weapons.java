package com.me.database.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="WPN_WEAPONS")
@Inheritance(strategy=InheritanceType.JOINED)

public class Weapons {
	public Weapons(int weaponId,int gameId,String weaponName,String weaponType,String description){
		this.weaponId=weaponId;
		this.weaponName=weaponName;
		this.description=description;
		this.gameId=gameId;
		this.weaponType=weaponType;
		
	}
	
	@Id
	@GeneratedValue
	@Column(name="WPN_WEAPON_ID", unique=true, nullable=false)
	private int weaponId;
	
	private int gameId;
	
	@Column(name="WPN_WEAPON_NM")
	private String weaponName;
	
	@Column(name="WPN_WEAPON_TYP")
	private String weaponType;
	
	@Column(name="WPN_WEAPON_DESC")
	private String description;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy = "weaponId")
	private Set<WeaponsInGame> listOfWeaInGame;
	
	public Weapons() {
		listOfWeaInGame = new HashSet<WeaponsInGame>();
	}

	/**
	 * @return the weaponId
	 */
	public int getWeaponId() {
		return weaponId;
	}

	/**
	 * @param weaponId the weaponId to set
	 */
	public void setWeaponId(int weaponId) {
		this.weaponId = weaponId;
	}

	/**
	 * @return the gameId
	 */
	public int getGameId() {
		return gameId;
	}

	/**
	 * @param gameId the gameId to set
	 */
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	/**
	 * @return the weaponName
	 */
	public String getWeaponName() {
		return weaponName;
	}

	/**
	 * @param weaponName the weaponName to set
	 */
	public void setWeaponName(String weaponName) {
		this.weaponName = weaponName;
	}

	/**
	 * @return the weaponType
	 */
	public String getWeaponType() {
		return weaponType;
	}

	/**
	 * @param weaponType the weaponType to set
	 */
	public void setWeaponType(String weaponType) {
		this.weaponType = weaponType;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the listOfWeaInGame
	 */
	public Set<WeaponsInGame> getListOfWeaInGame() {
		return listOfWeaInGame;
	}

	/**
	 * @param listOfWeaInGame the listOfWeaInGame to set
	 */
	public void setListOfWeaInGame(Set<WeaponsInGame> listOfWeaInGame) {
		this.listOfWeaInGame = listOfWeaInGame;
	}
	
	
}
