package pl.edu.pwr.jkopaczewski.schoolfinansesoap.service;


import pl.edu.pwr.jkopaczewski.schoolfinansesoap.model.Event;

import java.util.List;

public interface EventService {
    Event addEvent(Event event);
    List<Event> findAllEvents();
    Event updateEvent(Event event, Integer id);
    String deleteEvent(int eventId);
    Event getEventById(Integer eventId);
}
