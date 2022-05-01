package pl.edu.pwr.jkopaczewski.schoolfinansesoap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.edu.pwr.jkopaczewski.schoolfinansesoap.model.Event;
import pl.edu.pwr.jkopaczewski.schoolfinansesoap.model.Payment;
import pl.edu.pwr.jkopaczewski.schoolfinansesoap.repository.EventRepository;
import pl.edu.pwr.jkopaczewski.schoolfinansesoap.repository.PaymentRepository;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }

    public List<Event> findAllEvents() {
        return eventRepository.findAll();
    }

    public Event updateEvent(Event newEvent, Integer id) {
        return eventRepository.findById(Math.toIntExact(id))
                .map(event -> {
                    event.setName(newEvent.getName());
                    event.setDate(newEvent.getDate());
                    event.setPlace(newEvent.getPlace());
                    return eventRepository.save(event);
                })
                .orElseGet(() -> {
                    newEvent.setEventId(id);
                    return eventRepository.save(newEvent);
                });
    }

    public String deleteEvent(int eventId) {
        for(Payment item : paymentRepository.findAll()) {
            if (item.getPaymentEvent().getEventId() == eventId)
                paymentRepository.deleteById(item.getPaymentId());
        }
        eventRepository.deleteById(eventId);
        return ResponseEntity.ok().build().toString();
    }

    public Event getEventById(Integer eventId) {
        return eventRepository.getById(eventId);
    }
}
