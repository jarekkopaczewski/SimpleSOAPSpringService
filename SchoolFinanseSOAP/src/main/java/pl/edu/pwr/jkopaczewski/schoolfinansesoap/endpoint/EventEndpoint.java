package pl.edu.pwr.jkopaczewski.schoolfinansesoap.endpoint;

import localhost.DeleteEventRequest;
import localhost.DeleteEventResponse;
import localhost.GetEventRequest;
import localhost.GetEventResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pl.edu.pwr.jkopaczewski.schoolfinansesoap.service.EventService;
import pl.edu.pwr.jkopaczewski.schoolfinansesoap.soap.ResponseFactory;
import pl.edu.pwr.jkopaczewski.schoolfinansesoap.soap.SoapFactory;

@Endpoint
public class EventEndpoint {
    private static final String NAMESPACE_URI = "localhost";
    @Autowired
    EventService eventService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEventRequest")
    @ResponsePayload
    public GetEventResponse getEventResponse(@RequestPayload GetEventRequest request) {
        return ResponseFactory.eventResponseOf(SoapFactory.eventOf(eventService.getEventById(request.getEventId())));
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteEventRequest")
    @ResponsePayload
    public DeleteEventResponse deleteEventResponse(@RequestPayload DeleteEventRequest request) {
        return ResponseFactory.deleteEventResponseOf(eventService.deleteEvent(request.getEventId()));
    }
}
