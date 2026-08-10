package Task2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Task2.Service.AccountService;

public class Main {

	public static void main(String[] args) { 
		
	    ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
	    
		AccountService accountService = context.getBean("accountService", AccountService.class);
		accountService.getSavePerson("Ahmed");

	}

}
