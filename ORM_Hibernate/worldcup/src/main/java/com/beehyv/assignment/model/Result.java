package com.beehyv.assignment.model;

import javax.persistence.*;

@Entity
@Table(name = "result")
public class Result {

	@Id
    @Column(name = "id")
    private Integer id;
	
	@ManyToOne
    @JoinColumn(name = "winningTeamId")
	private Team winningTeam;
	
	@ManyToOne
    @JoinColumn(name = "losingTeamId")
	private Team losingTeam;
	
	@ManyToOne
    @JoinColumn(name = "playerOfTheMatchId")
	private Player playerOfTheMatch;
	
	@OneToOne
    @JoinColumn(name = "gameId")
	private Game game;

	public Result() {
	}
	
	public Result(int id, Game game, Team winningTeam, Team losingTeam, Player playerOfTheMatch) {
		this.id = id;
		this.game = game;
		this.winningTeam = winningTeam;
		this.losingTeam = losingTeam;
		this.playerOfTheMatch = playerOfTheMatch;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}

	public Team getWinningTeam() {
		return winningTeam;
	}
	public void setWinningTeam(Team winningTeam) {
		this.winningTeam = winningTeam;
	}

	public Team getLosingTeam() {
		return losingTeam;
	}
	public void setLosingTeam(Team losingTeam) {
		this.losingTeam = losingTeam;
	}

	public Player getPlayerOfTheMatch() {
		return playerOfTheMatch;
	}
	public void setPlayerOfTheMatch(Player playerOfTheMatch) {
		this.playerOfTheMatch = playerOfTheMatch;
	}

	@Override
	public String toString() {

		return "id="+id+", game="+game+", winningTeam="+winningTeam+", losingTeam="+losingTeam+", playerOfTheMatch="+playerOfTheMatch+"";
	}	
}
