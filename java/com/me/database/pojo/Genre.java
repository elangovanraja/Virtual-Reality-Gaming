package com.me.database.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="GEN_GENRE")
public class Genre {

	@Id
	@GeneratedValue
	@Column(name="GEN_GENRE_ID", unique=true, nullable=false)
	private int genreId;
	
	@Column(name="GEN_GENRE_NAME")
	private String genreName;
	
	@Column(name="GEN_DESCRIPTION")
	private String descrption;

	@OneToMany(fetch=FetchType.EAGER, mappedBy="genreId")
	private Set<Games> listOfGames; 
	
	public Genre() {
		listOfGames = new HashSet<Games>();
	}
	
	@Override
	public String toString() {
		return genreName;
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
	 * @return the genreName
	 */
	public String getGenreName() {
		return genreName;
	}

	/**
	 * @param genreName the genreName to set
	 */
	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	/**
	 * @return the descrption
	 */
	public String getDescrption() {
		return descrption;
	}

	/**
	 * @param descrption the descrption to set
	 */
	public void setDescrption(String descrption) {
		this.descrption = descrption;
	}

	/**
	 * @return the listOfGames
	 */
	public Set<Games> getListOfGames() {
		return listOfGames;
	}

	/**
	 * @param listOfGames the listOfGames to set
	 */
	public void setListOfGames(Set<Games> listOfGames) {
		this.listOfGames = listOfGames;
	}
	
}
