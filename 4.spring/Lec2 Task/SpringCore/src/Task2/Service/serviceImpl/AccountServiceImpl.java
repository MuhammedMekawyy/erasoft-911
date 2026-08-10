package Task2.Service.serviceImpl;

import Task2.Service.AccountService;

public class AccountServiceImpl implements AccountService {

    private PersonService personService;


    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public void getSavePerson(String name) {
        System.out.println("AccountServiceImpl: delegating to PersonService...");
        personService.save(name);
    }
}