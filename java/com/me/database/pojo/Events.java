package com.me.database.pojo;

import javax.persistence.*;

@Entity
@Table(name="EVT_EVENTS")

public class Events {
	@Id
	@GeneratedValue
	@Column(name="EVT_EVENT_ID", nullable=false, unique=true)
	int id;
	
	@Column(name="EVT_PART_ID")
	int participantId;
	
	public int getWeaponId() {
		return weaponId;
	}

	public Events(int participantId, int weaponId, int x_coordinate, int a_coordinate, int b_coordinate) {
		this.participantId = participantId;
		this.weaponId = weaponId;
		this.X_coordinate = x_coordinate;
		this.A_coordinate = a_coordinate;
		this.B_coordinate = b_coordinate;
	}

	public void setWeaponId(int weaponId) {
		this.weaponId = weaponId;
	}

	@Column(name="EVT_WeaponID")
	int weaponId;
	
	@Column(name="EVT_X")
	int X_coordinate;
	
	@Column(name="EVT_A")
	int A_coordinate;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getParticipantId() {
		return participantId;
	}

	public void setParticipantId(int participantId) {
		this.participantId = participantId;
	}

	public int getX_coordinate() {
		return X_coordinate;
	}

	public void setX_coordinate(int x_coordinate) {
		X_coordinate = x_coordinate;
	}

	public int getA_coordinate() {
		return A_coordinate;
	}

	public void setA_coordinate(int a_coordinate) {
		A_coordinate = a_coordinate;
	}

	public int getB_coordinate() {
		return B_coordinate;
	}

	public void setB_coordinate(int b_coordinate) {
		B_coordinate = b_coordinate;
	}

	@Column(name="EVT_B")
	int B_coordinate;
	
}
