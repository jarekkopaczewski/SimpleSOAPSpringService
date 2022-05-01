package pl.edu.pwr.jkopaczewski.schoolfinansesoap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.edu.pwr.jkopaczewski.schoolfinansesoap.model.Payment;
import pl.edu.pwr.jkopaczewski.schoolfinansesoap.model.Person;
import pl.edu.pwr.jkopaczewski.schoolfinansesoap.repository.PaymentRepository;
import pl.edu.pwr.jkopaczewski.schoolfinansesoap.repository.PersonRepository;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    public Person addPerson(Person person){ return personRepository.save(person); }

    public List<Person> getPeople() { return personRepository.findAll(); }

    public Person updatePerson(Person newPerson, Integer id) {
        return personRepository.findById(Math.toIntExact(id))
                .map(event -> {
                    event.setName(newPerson.getName());
                    event.setSurname(newPerson.getSurname());
                    return personRepository.save(event);
                })
                .orElseGet(() -> {
                    newPerson.setPersonId(id);
                    return personRepository.save(newPerson);
                });
    }

    public String deletePerson(Integer personId) {
        for(Payment item : paymentRepository.findAll()) {
            if (item.getPaymentPerson().getPersonId() == personId)
                paymentRepository.deleteById(item.getPaymentId());
        }
        personRepository.deleteById(personId);
        return ResponseEntity.ok().build().toString();
    }

    @Override
    public Person getPersonById(Integer personId) {
        return personRepository.getById(personId);
    }
}
