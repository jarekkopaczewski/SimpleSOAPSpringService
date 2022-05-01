package pl.edu.pwr.jkopaczewski.schoolfinansesoap.soap;

import pl.edu.pwr.jkopaczewski.schoolfinansesoap.model.Event;
import pl.edu.pwr.jkopaczewski.schoolfinansesoap.model.Payment;
import pl.edu.pwr.jkopaczewski.schoolfinansesoap.model.Person;

public class SoapFactory {

    public static localhost.Event eventOf(Event event){
        localhost.Event soap = new localhost.Event();
        soap.setDate(event.getDate());
        soap.setEventId(event.getEventId());
        soap.setPlace(event.getPlace());
        soap.setName(event.getName());
        return soap;
    }

    public static localhost.Payment paymentOf(Payment payment){
        localhost.Payment soap = new localhost.Payment();
        soap.setPayday(payment.getPayday());
        soap.setPayed(payment.isPayed());
        soap.setPaymentAmount(payment.getPaymentAmount());
        soap.setPaymentId(payment.getPaymentId());
        soap.setPaymentEvent(SoapFactory.eventOf(payment.getPaymentEvent()));
        soap.setInstalmentNumber(payment.getInstalmentNumber());
        soap.setPaymentDeadline(payment.getPaymentDeadline());
        soap.setPaymentPerson(SoapFactory.personOf(payment.getPaymentPerson()));
        return soap;
    }

    public static localhost.Person personOf(Person person){
        localhost.Person soap = new localhost.Person();
        soap.setName(person.getName());
        soap.setPersonId(person.getPersonId());
        soap.setSurname(person.getSurname());
        return soap;
    }
}
