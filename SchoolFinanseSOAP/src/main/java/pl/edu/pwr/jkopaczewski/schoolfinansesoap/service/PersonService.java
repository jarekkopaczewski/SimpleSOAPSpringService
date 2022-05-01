package pl.edu.pwr.jkopaczewski.schoolfinansesoap.service;

import pl.edu.pwr.jkopaczewski.schoolfinansesoap.model.Person;

import java.util.List;

public interface PersonService {
    Person addPerson(Person person);
    List<Person> getPeople();
    Person updatePerson(Person person, Integer id);
    String deletePerson(Integer personId);
    Person getPersonById(Integer personId);
}
