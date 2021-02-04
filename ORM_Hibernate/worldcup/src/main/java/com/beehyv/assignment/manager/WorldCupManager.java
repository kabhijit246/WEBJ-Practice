package com.beehyv.assignment.manager;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import com.beehyv.assignment.model.*;

public class WorldCupManager {

	Configuration con = new Configuration().configure()
			.addAnnotatedClass(Team.class)
			.addAnnotatedClass(Role.class)
			.addAnnotatedClass(Player.class)
			.addAnnotatedClass(Game.class)
			.addAnnotatedClass(Result.class);
	ServiceRegistry reg = new ServiceRegistryBuilder()
			.applySettings(con.getProperties())
			.buildServiceRegistry();
	SessionFactory sf = con.buildSessionFactory(reg);

	public <T> void fillTable(T t) {
		Transaction tx;
		Session session = sf.openSession();
		try {   		 
			tx = session.beginTransaction();
			session.save(t);
			tx.commit();
		} 
		catch (HibernateException e) {
			e.printStackTrace(); 			
		}
		finally {
			session.close();
		}
	}

	public void listTeam() {
		Transaction tx;
		Session session = sf.openSession();
		try {   		 
			tx = session.beginTransaction();
			Criteria cri = session.createCriteria(Team.class);
			List<Team> list =  cri.list();
			System.out.println("Team List: ");
			for(Team team: list)
				System.out.println( team.toString());
			tx.commit();
		} 
		catch (HibernateException e) {
			e.printStackTrace(); 			
		}
		finally {
			session.close();
		} 	 
	}

	public void listRole() {
		Transaction tx;
		Session session = sf.openSession();
		try {   		 
			tx = session.beginTransaction();
			Criteria cri = session.createCriteria(Role.class);
			List<Role> list =  cri.list();
			System.out.println("Role List: ");
			for(Role role: list)
				System.out.println( role.toString());
			tx.commit();
		} 
		catch (HibernateException e) {
			e.printStackTrace(); 			
		}
		finally {
			session.close();
		} 	 
	}

	public void listPlayer() {
		Transaction tx;
		Session session = sf.openSession();
		try {   		 
			tx = session.beginTransaction();
			Criteria cri = session.createCriteria(Player.class);
			List<Player> list =  cri.list();
			System.out.println("Player List: ");
			for(Player player : list)
				System.out.println( player.toString());
			tx.commit();
		} 
		catch (HibernateException e) {
			e.printStackTrace(); 			
		}
		finally {
			session.close();
		} 	 
	}

	public void listGame() {
		Transaction tx;
		Session session = sf.openSession();
		try {   		 
			tx = session.beginTransaction();
			Criteria cri = session.createCriteria(Game.class);
			List<Game> list =  cri.list();
			System.out.println("Game List: ");
			for(Game game : list)
				System.out.println( game.toString());
			tx.commit();
		}
		catch (HibernateException e) {
			e.printStackTrace(); 			
		}
		finally {
			session.close();
		} 	 
	}

	public void listResult() {
		Transaction tx;
		Session session = sf.openSession();
		try {   		 
			tx = session.beginTransaction();
			Criteria cri = session.createCriteria(Result.class);
			List<Result> list =  cri.list();
			System.out.println("Result List: ");
			for(Result result : list)
				System.out.println( result.toString());
			tx.commit();
		} 
		catch (HibernateException e) {
			e.printStackTrace(); 			
		}
		finally {
			session.close();
		} 	 
	}

	public void updateTeam(int id, String name) {

		Session session = sf.openSession();
		Transaction tx = null;       
		try {
			tx = session.beginTransaction();
			Team team = (Team) session.get(Team.class, id);
			team.setName(name);
			session.update(team); 
			tx.commit();
		} 
		catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} 
		finally {
			session.close(); 
		}
	}

	public void updateRole(int id, String name) {

		Session session = sf.openSession();
		Transaction tx = null;       
		try {
			tx = session.beginTransaction();
			Role role = (Role) session.get(Role.class, id);
			role.setName(name);
			session.update(role); 
			tx.commit();
		} 
		catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} 
		finally {
			session.close(); 
		}

	}

	public void updatePlayer(int id, String name, Team team, Role role) {

		Session session = sf.openSession();
		Transaction tx = null;       
		try {
			tx = session.beginTransaction();
			Player player = (Player) session.get(Player.class, id);
			player.setName(name);
			player.setTeam(team);
			player.setRole(role);
			session.update(player); 
			tx.commit();
		} 
		catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} 
		finally {
			session.close(); 
		}

	}

	public void deletePlayer(int id) {
		Session session = sf.openSession();
		Transaction tx = null;        
		try {
			tx = session.beginTransaction();
			Player player = (Player) session.get(Player.class, id);
			session.delete(player); 
			tx.commit();
		} 
		catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} 
		finally {
			session.close(); 
		}
	}

	public void deleteGame(int id) {
		Session session = sf.openSession();
		Transaction tx = null;        
		try {
			tx = session.beginTransaction();
			Game game = (Game) session.get(Game.class, id);
			session.delete(game); 
			tx.commit();
		} 
		catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} 
		finally {
			session.close(); 
		}

	}

	public void deleteResult(int id) { 
		Session session = sf.openSession();
		Transaction tx = null;        
		try {
			tx = session.beginTransaction();
			Result result = (Result) session.get(Result.class, id);
			session.delete(result); 
			tx.commit();
		} 
		catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} 
		finally {
			session.close(); 
		}  	 
	}
}
