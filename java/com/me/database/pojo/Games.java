package com.me.database.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="GAM_GAMES")

public class Games {

	@Id
	@GeneratedValue
	@Column(name="GAM_GAME_ID", nullable=false, unique=true)
	private int gameId;
	
	@Column(name="GAM_GAME_NAME")
	private String gameName;
	
	
	private int genreId;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="gameId")
	private Set<Characters> listOfCharacters;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="gameId")
	private Set<Weapons> listOfWeapons;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="gameId")
	private Set<Participants> listOfParticipants;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="gameId")
	private Set<Environment> listOfEnvironments;
	
	public Games() {
		listOfCharacters = new HashSet<Characters>();
		listOfEnvironments = new HashSet<Environment>();
		listOfWeapons = new HashSet<Weapons>();
		listOfParticipants = new HashSet<Participants>();
		
	}

	/**
	 * @return the gameId
	 */
	@Override
	public String toString() {
		return gameName;
	}
	public int getGameId() {
		return gameId;
	}

	/**
	 * @return the listOfEnvironments
	 */
	public Set<Environment> getListOfEnvironments() {
		return listOfEnvironments;
	}

	/**
	 * @param listOfEnvironments the listOfEnvironments to set
	 */
	public void setListOfEnvironments(Set<Environment> listOfEnvironments) {
		this.listOfEnvironments = listOfEnvironments;
	}

	/**
	 * @param gameId the gameId to set
	 */
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	/**
	 * @return the gameName
	 */
	public String getGameName() {
		return gameName;
	}

	/**
	 * @param gameName the gameName to set
	 */
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	/**
	 * @return the genreId
	 */
	public int getGenreId() {
		return genreId;
	}

	/**
	 * @param genreId the genreId to set
	 */
	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}

	/**
	 * @return the listOfCharacters
	 */
	public Set<Characters> getListOfCharacters() {
		return listOfCharacters;
	}

	/**
	 * @param listOfCharacters the listOfCharacters to set
	 */
	public void setListOfCharacters(Set<Characters> listOfCharacters) {
		this.listOfCharacters = listOfCharacters;
	}

	/**
	 * @return the listOfWeapons
	 */
	public Set<Weapons> getListOfWeapons() {
		return listOfWeapons;
	}

	/**
	 * @param listOfWeapons the listOfWeapons to set
	 */
	public void setListOfWeapons(Set<Weapons> listOfWeapons) {
		this.listOfWeapons = listOfWeapons;
	}

	/**
	 * @return the listOfParticipants
	 */
	public Set<Participants> getListOfParticipants() {
		return listOfParticipants;
	}

	/**
	 * @param listOfParticipants the listOfParticipants to set
	 */
	public void setListOfParticipants(Set<Participants> listOfParticipants) {
		this.listOfParticipants = listOfParticipants;
	}
	
	
	
	
}
