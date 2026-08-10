package Task2.Service.serviceImpl;

import Task2.Service.userService;

public class PersonService implements userService {

    @Override
    public void save(String name) {
        System.out.println("PersonService: saving person -> " + name);
    }

    @Override
    public void update(String name) {
        System.out.println("PersonService: updating person -> " + name);
    }
}