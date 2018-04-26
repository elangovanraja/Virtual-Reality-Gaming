package com.me.database.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="CHR_CHRCTRS")

public class Characters {

	@Id
	@GeneratedValue
	@Column(name="CHR_CHRCTR_ID", unique=true, nullable=false)
	private int characterId;
	
	@Override
	public String toString() {
		return characterName;
	}

	private int gameId;
	
	@Column(name="CHR_CHRCTCR_NM")
	private String characterName;
	
	@Column(name="CHR_CHRCTR_TYP")
	private String characterType;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="characterId")
	private Set<ParticipantsInGame> listOfPartInGame;
	
	public Characters() {
		listOfPartInGame = new HashSet<ParticipantsInGame>();
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
	 * @return the characterName
	 */
	public String getCharacterName() {
		return characterName;
	}

	/**
	 * @param characterName the characterName to set
	 */
	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	/**
	 * @return the characterType
	 */
	public String getCharacterType() {
		return characterType;
	}

	/**
	 * @param characterType the characterType to set
	 */
	public void setCharacterType(String characterType) {
		this.characterType = characterType;
	}

	/**
	 * @return the listOfPartInGame
	 */
	public Set<ParticipantsInGame> getListOfPartInGame() {
		return listOfPartInGame;
	}

	/**
	 * @param listOfPartInGame the listOfPartInGame to set
	 */
	public void setListOfPartInGame(Set<ParticipantsInGame> listOfPartInGame) {
		this.listOfPartInGame = listOfPartInGame;
	}
	
	
}
