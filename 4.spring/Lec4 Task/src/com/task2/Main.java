package com.task2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration()
				.addAnnotatedClass(Doctor.class)
				.addAnnotatedClass(DoctorDetails.class)
				.addAnnotatedClass(Hospital.class)
				.addAnnotatedClass(Patient.class)
				.configure("hibernate.cfg.xml");
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession(); 
		Transaction transaction = session.getTransaction();
		transaction.begin();

	}

}
