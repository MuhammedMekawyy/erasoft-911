import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import serviceImpl.MangerService;
import serviceImpl.PersonService;

public class Main {

	public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get beans from the Container
        PersonService personService = context.getBean("personService", PersonService.class);
        MangerService mangerService = context.getBean("mangerService", MangerService.class);

        // Call methods
        personService.save("John Doe");
        personService.update("John Doe2");

        mangerService.save("Jane Smith");
        mangerService.update("Jane Smith2");

	}

}
