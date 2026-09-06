package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) { 
		
		Configuration configuration = new Configuration()
				.addAnnotatedClass(Player.class)
				.configure("hibernate.cfg.xml");
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession(); 
		Transaction transaction = session.getTransaction();
		transaction.begin();
	
		
		
		Player p1 = new Player(1, "Ahmed", 20, true);
		Player p2 = new Player(2, "Mohamed", 25, false);
		Player p3 = new Player(3, "Ali", 30, true);
		
		
		session.save(p1);
		session.save(p2);
		session.save(p3);
		
		
		session.remove(p1); 
		
		Player p4 = session.get(Player.class, 2); 
		System.out.println(p4);
		
		p2.setName("Mekk"); 
	

		
		transaction.commit();
		

	}

}
