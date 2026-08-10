package Task1.service.serviceImpl;



import Task1.service.UserService;




public class PersonService implements UserService {

	@Override
	public void save(String name) {
		System.out.println("PersonService save method called with name: " + name);
		
	}

	@Override
	public void update(String name) {
		System.out.println("PersonService update method called with name: " + name);
		
	}
 
}
