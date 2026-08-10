package Task3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Task3.service.UserService;

public class Main {

	public static void main(String[] args) { 
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService personService = context.getBean("personService3", UserService.class);
		personService.save("Ahmed");
		
	}

}
