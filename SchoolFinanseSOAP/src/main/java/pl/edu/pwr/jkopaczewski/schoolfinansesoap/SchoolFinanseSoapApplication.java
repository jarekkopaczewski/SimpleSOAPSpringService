package pl.edu.pwr.jkopaczewski.schoolfinansesoap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.edu.pwr.jkopaczewski.schoolfinansesoap.model.Event;
import pl.edu.pwr.jkopaczewski.schoolfinansesoap.model.Payment;
import pl.edu.pwr.jkopaczewski.schoolfinansesoap.model.Person;
import pl.edu.pwr.jkopaczewski.schoolfinansesoap.service.EventService;
import pl.edu.pwr.jkopaczewski.schoolfinansesoap.service.PaymentService;
import pl.edu.pwr.jkopaczewski.schoolfinansesoap.service.PersonService;

@SpringBootApplication
public class SchoolFinanseSoapApplication implements CommandLineRunner {

    private final EventService eventService;
    private final PaymentService paymentService;
    private final PersonService personService;

    @Autowired
    public SchoolFinanseSoapApplication(EventService eventService, PaymentService paymentService, PersonService personService) {
        this.eventService = eventService;
        this.paymentService = paymentService;
        this.personService = personService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SchoolFinanseSoapApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Event event = new Event("Wycieczka", "Wrocław", "12.12.2023");
        eventService.addEvent(event);
        eventService.addEvent(new Event("Wyjście do muzeum", "Kraków", "10.09.2023"));
        eventService.addEvent(new Event("Wyjazd na basen", "Wrocław", "08.02.2024"));

        Person person = new Person("Jan", "Nowak");
        personService.addPerson(person);
        personService.addPerson(new Person("Karol", "Gieniec"));
        personService.addPerson(new Person("Klaudia", "Zdęba"));
        personService.addPerson(new Person("Kuba", "Grzyb"));

        paymentService.addPayment(new Payment("01.11.2023", 100, 1, event, person));
        paymentService.addPayment(new Payment("15.11.2023", 100, 2, event, person));
        paymentService.addPayment(new Payment("01.12.2023", 100, 3, event, person));
    }
}
