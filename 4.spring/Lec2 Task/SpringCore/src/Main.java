import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Task1.service.serviceImpl.MangerService;
import Task1.service.serviceImpl.PersonService;

public class Main {

	public static void main(String[] args) {
		 
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get beans from the Container
        PersonService personService = context.getBean("personService", PersonService.class);
        MangerService mangerService = context.getBean("myManger", MangerService.class);

        // Call methods
        personService.save("kkk");
        personService.update("kkk2");

        mangerService.save("mmm");
        mangerService.update("mmm2");

	}

}
