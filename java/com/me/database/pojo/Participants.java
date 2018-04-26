package com.me.database.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@SequenceGenerator(name="seq", initialValue=8, allocationSize=1000)
@Table(name="PAR_PRTCPNT")
public class Participants {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	@Column(name="PAR_PRTCPNT_ID", unique=true, nullable=false)
	private int participantId;
	
	@Column(name="PAR_PRTCPNT_NM")
	private String participantName;
	
	@Override
	public String toString() {
		return participantName;
	}
	
	public Participants(String participantName,int gameId){
		this.gameId=gameId;
		this.participantName=participantName;
		listOfParInGame = new HashSet<ParticipantsInGame>();
	}

	private int gameId;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy = "partId")
	private Set<ParticipantsInGame> listOfParInGame;
	
	public Participants() {
		listOfParInGame = new HashSet<ParticipantsInGame>();
	}

	/**
	 * @return the participantId
	 */
	public int getParticipantId() {
		return participantId;
	}

	/**
	 * @param participantId the participantId to set
	 */
	public void setParticipantId(int participantId) {
		this.participantId = participantId;
	}

	/**
	 * @return the participantName
	 */
	public String getParticipantName() {
		return participantName;
	}

	/**
	 * @param participantName the participantName to set
	 */
	public void setParticipantName(String participantName) {
		this.participantName = participantName;
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
	 * @return the listOfParInGame
	 */
	public Set<ParticipantsInGame> getListOfParInGame() {
		return listOfParInGame;
	}

	/**
	 * @param listOfParInGame the listOfParInGame to set
	 */
	public void setListOfParInGame(Set<ParticipantsInGame> listOfParInGame) {
		this.listOfParInGame = listOfParInGame;
	}
	
}
