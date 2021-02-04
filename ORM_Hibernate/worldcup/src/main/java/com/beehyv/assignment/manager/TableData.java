package com.beehyv.assignment.manager;

import com.beehyv.assignment.model.*;

public class TableData {

	public static void main( String[] args )
	{
		Team team1 = new Team(1, "India");
		Team team2 = new Team(2, "Australia");
		Team team3 = new Team(3, "England");
		Team team4 = new Team(4, "NewZealand");

		Role role1 = new Role(1, "Batsman");
		Role role2 = new Role(2, "Bowler");
		Role role3 = new Role(3, "Allrounder");

		Player p1 = new Player(1, "Sachin Tendulkar", team1, role1);
		Player p2 = new Player(2, "Zaheer Khan", team1, role2);
		Player p3 = new Player(3, "Yuvraj Singh", team1, role3);
		Player p4 = new Player(4, "Ricky Ponting", team2, role1);
		Player p5 = new Player(5, "Brett Lee", team2, role2);
		Player p6 = new Player(6, "Glenn Maxwell", team2, role3);
		Player p7 = new Player(7, "Alastair Cook",team3, role1);
		Player p8 = new Player(8, "James Anderson", team3, role2);
		Player p9 = new Player(9, "Ben Stokes", team3, role3);
		Player p10 = new Player(10, "Brendon Macculum", team4, role1);
		Player p11 = new Player(11, "Trent Boult", team4, role2);
		Player p12 = new Player(12, "James Neesham", team4, role3);

		Game g1 = new Game(1, team1, team2);
		Game g2 = new Game(2, team1, team3);
		Game g3 = new Game(3, team1, team4);

		Result r1 = new Result(1, g1, team1, team2, p1);
		Result r2 = new Result(2, g2, team1, team3, p2);
		Result r3 = new Result(3, g3, team1, team4, p2);

		WorldCupManager m = new WorldCupManager();

		m.fillTable(team1);
		m.fillTable(team2);
		m.fillTable(team3);
		m.fillTable(team4);

		m.fillTable(role1);
		m.fillTable(role2);
		m.fillTable(role3);

		m.fillTable(p1);
		m.fillTable(p2);
		m.fillTable(p3);
		m.fillTable(p4);
		m.fillTable(p5);
		m.fillTable(p6);
		m.fillTable(p7);
		m.fillTable(p8);
		m.fillTable(p9);
		m.fillTable(p10);
		m.fillTable(p11);
		m.fillTable(p12);

		m.fillTable(g1);
		m.fillTable(g2);
		m.fillTable(g3);

		m.fillTable(r1);
		m.fillTable(r2);
		m.fillTable(r3);

		m.listTeam();
		m.listRole();
		m.listPlayer();
		m.listGame();
		m.listResult();

		m.updatePlayer(5, "Shane Warne", team2, role2);
		m.updateRole(3,"Wicket-Keeper");
		m.updateTeam(4, "South-Africa");

		m.deletePlayer(6);
		m.deleteGame(2);
		m.deleteResult(2);

	}
}
