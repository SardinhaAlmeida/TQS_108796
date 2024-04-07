package HW1.service;

import org.springframework.stereotype.Service;

import HW1.model.Person;

@Service
public interface PersonService {

    public Person savePerson(Person person);    
}
