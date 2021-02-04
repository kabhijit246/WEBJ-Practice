package com.beehyv.assignment.model;

import javax.persistence.*;

@Entity
@Table(name="game")
public class Game {

	@Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
	
	@ManyToOne
    @JoinColumn(name = "team1_id")
	private Team team1;
	
	@ManyToOne
    @JoinColumn(name = "team2_id")
	private Team team2;

	public Game() {
	}
	
	public Game(int id, Team team1, Team team2) {
		this.id = id;
		this.team1 = team1;
		this.team2 = team2;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Team getTeam1() {
		return team1;
	}
	public void setTeam1(Team team1) {
		this.team1 = team1;
	}

	public Team getTeam2() {
		return team2;
	}
	public void setTeam2(Team team2) {
		this.team2 = team2;
	}

	@Override
	public String toString() {
		return "id="+id+", team1="+team1+", team2="+team2+"";
	}
}
