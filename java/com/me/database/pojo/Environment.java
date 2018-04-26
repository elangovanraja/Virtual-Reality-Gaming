package com.me.database.pojo;

import javax.persistence.*;

@Entity
@Table(name="ENV_ENVIRONMENT")
public class Environment {

	@Id
	@GeneratedValue
	@Column(name="ENV_ENV_ID", unique=true, nullable=false)
	private int envId;
	
	@Column(name="ENV_ENV_NM")
	private String envName;
	
	private int gameId;

	/**
	 * @return the envId
	 */
	public int getEnvId() {
		return envId;
	}

	/**
	 * @param envId the envId to set
	 */
	public void setEnvId(int envId) {
		this.envId = envId;
	}

	/**
	 * @return the envName
	 */
	public String getEnvName() {
		return envName;
	}

	/**
	 * @param envName the envName to set
	 */
	public void setEnvName(String envName) {
		this.envName = envName;
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
	
	
}
