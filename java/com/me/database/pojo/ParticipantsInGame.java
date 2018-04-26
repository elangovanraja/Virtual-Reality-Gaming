package com.me.database.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="CHP_PRTPNT_GAME")
@SequenceGenerator(name="seq", initialValue=1, allocationSize=1000)
public class ParticipantsInGame {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	@Column(name="CHP_PRTPNT_TABLE_ID", nullable=false, unique=true)
	private int tableid;
	
	@Column(name="CHP_PRTPNT_GAME_ID")
	private int id;
	
	public int getTableid() {
		return tableid;
	}

	public void setTableid(int tableid) {
		this.tableid = tableid;
	}

	private int partId;
	
	private int characterId;
	@Column(name="HEAD_VIB_LVL")
	private int headVibLevel;
	
	@Column(name="BODY_VIB_LVL")
	private int bodyVibLevel;
	
	@Column(name="HIT_POINTS")
	private int hitPoints;
	
	@Column(name="CHP_STATUS")
	private String status;

	@OneToMany(fetch=FetchType.EAGER, mappedBy = "participantId")
	private Set<WeaponsInGame> listOfWeaInGame;
	
	public ParticipantsInGame() {
		listOfWeaInGame = new HashSet<WeaponsInGame>();
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
	
	
	public ParticipantsInGame(int partId, int characterId)
	{		listOfWeaInGame = new HashSet<WeaponsInGame>();
		this.partId=partId;
		this.characterId=characterId;
		this.bodyVibLevel=0;
		this.headVibLevel=0;
		this.status="Alive";
		this.hitPoints=100;
		System.out.println(this.tableid);
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the partId
	 */
	public int getPartId() {
		return partId;
	}

	/**
	 * @param partId the partId to set
	 */
	public void setPartId(int partId) {
		this.partId = partId;
	}

	/**
	 * @return the characterId
	 */
	public int getCharacterId() {
		return characterId;
	}

	/**
	 * @param characterId the characterId to set
	 */
	public void setCharacterId(int characterId) {
		this.characterId = characterId;
	}

	/**
	 * @return the headVibLevel
	 */
	public int getHeadVibLevel() {
		return headVibLevel;
	}

	/**
	 * @param headVibLevel the headVibLevel to set
	 */
	public void setHeadVibLevel(int headVibLevel) {
		this.headVibLevel = headVibLevel;
	}

	/**
	 * @return the bodyVibLevel
	 */
	public int getBodyVibLevel() {
		return bodyVibLevel;
	}

	/**
	 * @param bodyVibLevel the bodyVibLevel to set
	 */
	public void setBodyVibLevel(int bodyVibLevel) {
		this.bodyVibLevel = bodyVibLevel;
	}

	/**
	 * @return the hitPoints
	 */
	public int getHitPoints() {
		return hitPoints;
	}

	/**
	 * @param hitPoints the hitPoints to set
	 */
	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
