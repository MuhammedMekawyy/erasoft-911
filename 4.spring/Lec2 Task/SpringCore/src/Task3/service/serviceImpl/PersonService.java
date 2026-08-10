package Task3.service.serviceImpl;


import Task3.service.UserService;


public class PersonService implements UserService {
  
    public void init() {
        System.out.println("PersonService: init() called - bean initialized");
    }

    @Override
    public void save(String name) {
        System.out.println("PersonService: saving -> " + name);
    }

 
    public void destroy() {
        System.out.println("PersonService: destroy() called - bean destroyed");
    }
}
