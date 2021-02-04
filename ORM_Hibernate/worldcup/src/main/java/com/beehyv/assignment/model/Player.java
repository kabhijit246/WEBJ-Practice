package com.beehyv.assignment.model;

import javax.persistence.*;

@Entity
@Table(name="player")
public class Player {

	@Id
    @Column(name = "id")
	private int id;
	
	@Column(name="name")
	private String name;

	@ManyToOne
	@JoinColumn(name="teamId")
	private Team team;

	@ManyToOne
	@JoinColumn(name="roleId")
	private Role role;

	public Player() {
	}
	
	public Player(int id, String name, Team team, Role role) {
		this.id = id;
		this.name = name;
		this.team = team;
		this.role = role;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}

	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "id="+id+", name="+name+", team="+team+", role="+role+"";
	}
}
