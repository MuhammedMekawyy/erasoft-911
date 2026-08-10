package Task1.service.serviceImpl;

import org.springframework.stereotype.Component;

import Task1.service.UserService;


@Component("myManger")
public class MangerService implements UserService {

	@Override
	public void save(String name) {
		System.out.println("MangerService save method called with name: " + name);
		
	}

	@Override
	public void update(String name) {
		System.out.println("MangerService update method called with name: " + name);
		
	}
 
}