package pl.edu.pwr.jkopaczewski.schoolfinansesoap.endpoint;

import localhost.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pl.edu.pwr.jkopaczewski.schoolfinansesoap.service.PersonService;
import pl.edu.pwr.jkopaczewski.schoolfinansesoap.soap.ResponseFactory;
import pl.edu.pwr.jkopaczewski.schoolfinansesoap.soap.SoapFactory;

@Endpoint
public class PersonEndpoint {
    private static final String NAMESPACE_URI = "localhost";
    @Autowired
    PersonService personService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPersonRequest")
    @ResponsePayload
    public GetPersonResponse getPersonResponse(@RequestPayload GetPersonRequest request) {
        return ResponseFactory.personResponseOf(SoapFactory.personOf(personService.getPersonById(request.getPersonId())));
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deletePersonRequest")
    @ResponsePayload
    public DeletePersonResponse deletePersonResponse(@RequestPayload DeletePersonRequest request) {
        return ResponseFactory.deletePersonResponseOf(personService.deletePerson(request.getPersonId()));
    }
}
