package com.beehyv.assignment.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.beehyv.assignment.model.*;

public class Criterias {

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
	
	
	public void indiaWonAgainstAustralia(String string) {
		Session session = sf.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Criteria c1 = session.createCriteria(Team.class);
			c1.add(Restrictions.like("name", "Australia"));
			Team team = (Team) c1.uniqueResult();

			Criteria c2 = session.createCriteria(Player.class);
			c2.add( Restrictions.like("name", string) );
			Player player = (Player) c2.uniqueResult();

			Criteria c3 =   session.createCriteria(Result.class);
			c3.add(Restrictions.eq("losingTeam", team));
			c3.add(Restrictions.eq("playerOfTheMatch", player));

			List<Result> list = c3.list();
			for(Result result : list) {
				System.out.println("Match ID: "+result.getGame().getId());
				System.out.println("Match won by: "+ result.getWinningTeam().getName());
				System.out.println(string + " is the Player of the Match.");
			}
			
			tx.commit();     	
		} 
		catch (HibernateException e) {
			if(tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}      	  

	}


	public void indianBowlerManOfTheMatch() {

		Session session = sf.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Criteria c1 = session.createCriteria(Team.class);
			c1.add(Restrictions.like("name", "India"));
			Team team = (Team) c1.uniqueResult();

			Criteria c2 = session.createCriteria(Role.class);
			c2.add(Restrictions.like("name", "Bowler"));
			Role role = (Role) c2.uniqueResult();

			Criteria c3 = session.createCriteria(Result.class);
			c3.add(Restrictions.eq("winningTeam", team));
			List<Result> list = c3.list();

			for(Result result : list) {
				if(result.getPlayerOfTheMatch().getRole().equals(role)) {
					System.out.println("Match ID: "+result.getGame().getId());
					System.out.println("Match won by: "+ result.getWinningTeam().getName());
					System.out.println("Bowler " + result.getPlayerOfTheMatch().getName() +" is the player of the match.");
				}   			  
			}		   
			tx.commit();			
		}
		catch (HibernateException e) {
			if(tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}   	      	  
	}
}

