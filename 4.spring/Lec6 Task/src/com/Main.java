package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) { 
		Configuration configuration = new Configuration()
				.addAnnotatedClass(User.class)
				.addAnnotatedClass(UserDetails.class)
				.addAnnotatedClass(Friend.class)
				.addAnnotatedClass(Post.class)
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Person.class)
				.configure("hibernate.cfg.xml");
		
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		Transaction transaction = session.getTransaction();
		transaction.begin();  
		
		
//		  User user1 = new User("Alice", 28);
//	      UserDetails details1 = new UserDetails("123 Main St, Cairo", "010-1111-1111");  
//	      
//	      List<Friend> friends = new ArrayList<>();
//
//	      friends.add(new Friend("Ahmed"));
//	      friends.add(new Friend("Mohamed"));
//	      friends.add(new Friend("Ali")); 
//	      
//	      Post post1 = new Post("Hello World", "This is Alice's first post."); 
	      
	      
	      /*save user with userDetails*/ 
	      
//	      session.save(user1); 
//	      details1.setUser(user1);
//	      session.save(details1);   
	      
	      
	      /*using cascade*/  
	      
//	      details1.setUser(user1);
//	      session.persist(details1); 
	      
	      /*save user with friends*/
	      
//	      friends.stream().forEach(f -> session.save(f));
//	      user1.setFriends(friends); 
//	      session.save(user1); 
	      
	      /*using cascade*/ 
	      
//	      user1.setFriends(friends); 
//	      session.persist(user1);
	       
	      
	      /*save user with post*/ 
	      
//	      session.save(user1);
//	      post1.setUser(user1);
//	      session.save(post1); 
	      
	      
	      /*using cascade*/ 
//	      
//	      post1.setUser(user1); 
//	      session.persist(post1);   
	      
//	        transaction.commit();
	      
//------------------------------------------------------ (task 1 2 3) 
	      
//	        User user1 = new User("Alice", 28);
//	        UserDetails details1 = new UserDetails("123 Main St, Cairo", "010-1111-1111");
//	        details1.setUser(user1);
//	        session.persist(details1);
//	 
//	        transaction.commit();
//	 
//	        // --- New transaction: fetch and observe lazy loading ---
//	        Transaction readTx = session.getTransaction();
//	        readTx.begin();
//	 
//	        System.out.println("Fetching UserDetails by id: " + details1.getId());
//	        UserDetails fetchedDetails = session.get(UserDetails.class, details1.getId());
//	 
//	        System.out.println("Got UserDetails object (User is NOT loaded yet if LAZY).");
//	        System.out.println("Is User initialized? " + Hibernate.isInitialized(fetchedDetails.getUser()));
//	 
//	        // Touching a field on User triggers the lazy proxy to initialize
//	        System.out.println("Now accessing user.getName() -> triggers SELECT on users table:");
//	        System.out.println("User name: " + fetchedDetails.getUser().getName());
//	        System.out.println("Is User initialized now? " + Hibernate.isInitialized(fetchedDetails.getUser()));
//	 
//	        readTx.commit();
	      
	          
	    
//	      Employee emp = new Employee("Sara", 12000.0, "Engineering");
//	        Customer cust = new Customer("Omar", 350);
//	 
//	        session.persist(emp);
//	        session.persist(cust);
//	 
//	        transaction.commit();
//	 
//	        // --- Query back through the base class ---
//	        Transaction readTx = session.getTransaction();
//	        readTx.begin();
//	 
//	        List<Person> people = session.createQuery("from Person", Person.class).list();
//	        System.out.println("All people (base class query):");
//	        people.forEach(p -> System.out.println("  " + p));
//	 
//	        Employee fetchedEmployee = session.get(Employee.class, emp.getId());
//	        System.out.println("Fetched Employee: " + fetchedEmployee);
//	 
//	        Customer fetchedCustomer = session.get(Customer.class, cust.getId());
//	        System.out.println("Fetched Customer: " + fetchedCustomer);
//	 
//	        readTx.commit(); 
	      
//----------------------------------------------------------------(task 4 5) 	      
	      
	      

	}

}
