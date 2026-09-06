package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Main {

	public static void main(String[] args) {
		Configuration configuration = new Configuration()
				.addAnnotatedClass(User.class)
				.addAnnotatedClass(UserDetails.class)
				.addAnnotatedClass(Orders.class)
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Course.class)
				.configure("hibernate.cfg.xml");
		
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		Transaction transaction = session.getTransaction();
		transaction.begin(); 
		
		User user = new User("ahmed", "123456");
		UserDetails userDetails = new UserDetails("Ahmed", "Ali", "Cairo");
		
		/*save*/ 
		
//		session.save(user);
//		userDetails.setUser(user);
//		session.save(userDetails); 
		
		/*persist from userDetails*/ 
		
//		userDetails.setUser(user);
//		session.persist(userDetails);  
		
		/*persist from user*/ 
		
//		user.setUserDetails(userDetails);
//		session.persist(user); 
//		userDetails.setUser(user); 
		
		
//--------------------------------------------------------------(one to one)
		
		User user2 = new User("mek", "3456"); 
		List<Orders> orders = new ArrayList();
		orders.add(new Orders("ORD-001", 150.0));
		orders.add(new Orders("ORD-002", 250.0));
		orders.add(new Orders("ORD-003", 350.0));
		orders.add(new Orders("ORD-004", 450.0)); 
		
		/* save */  
		
//		session.save(user2);
//		orders.stream().forEach(order -> {
//			order.setUser(user2);
//			session.save(order);
//		}
//				); 
		
		 
		/* persist from order*/ 
		
//		orders.stream().forEach(order -> {
//			order.setUser(user2);
//			session.persist(order);
//		}
//				); 
		
		/*persist from user*/
		
//		user2.setOrders(orders); 
//		session.persist(user2); 
//		orders.stream().forEach(x->x.setUser(user2));
//		 
		
//-----------------------------------------(one to many) 
		
		Course c1 = new Course("Java", 1000);
		Course c2 = new Course("Hibernate", 1500);
		Course c3 = new Course("Spring", 2000); 
		
		
		List<Course> courses1 = Arrays.asList(c1, c2);
		List<Course> courses2 = Arrays.asList(c2, c3);
		List<Course> courses3 = Arrays.asList(c1, c3);

		Student s1 = new Student("Ahmed", "1234");
		Student s2 = new Student("Mohamed", "5678");
		Student s3 = new Student("Ali", "9999"); 
		
		List<Student> students1 = Arrays.asList(s1, s3);
		List<Student> students2 = Arrays.asList(s1, s2);
		List<Student> students3 = Arrays.asList(s2, s3); 
		
		
		/*save*/ 
		
//		session.save(c1);
//		session.save(c2);
//		session.save(c3); 
//		
//		s1.setCourses(courses1);
//		s2.setCourses(courses2);
//		s3.setCourses(courses3); 
//		
//		session.save(s1);
//		session.save(s2);
//		session.save(s3);
		
		
		/*persist student*/ 
		
//		s1.setCourses(courses1);
//		s2.setCourses(courses2);
//		s3.setCourses(courses3); 
//		
//		session.persist(s1);
//		session.persist(s2);
//		session.persist(s3);	
		
		/*persist course*/ 

//		c1.setStudents(students1);
//		c2.setStudents(students2);
//		c3.setStudents(students3);
//		
//		session.persist(c1);
//		session.persist(c2);
//		session.persist(c3); 
//		
//		s1.setCourses(courses1);
//		s2.setCourses(courses2);
//		s3.setCourses(courses3); 
		
		
//------------------------------------------(many to many)
		

		
		transaction.commit();
		
	}

}
