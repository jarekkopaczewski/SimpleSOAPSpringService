package pl.edu.pwr.jkopaczewski.schoolfinansesoap.soap;

import localhost.*;

public class ResponseFactory {

    public static GetEventResponse eventResponseOf(localhost.Event soapEvent){
        GetEventResponse response = new GetEventResponse();
        response.setEvent(soapEvent);
        return response;
    }

    public static DeleteEventResponse deleteEventResponseOf(String string){
        DeleteEventResponse response = new DeleteEventResponse();
        response.setResponse(string);
        return response;
    }

    public static GetPaymentResponse paymentResponseOf(localhost.Payment soapPayment){
        GetPaymentResponse response = new GetPaymentResponse();
        response.setPayment(soapPayment);
        return response;
    }

    public static DeletePaymentResponse deletePaymentResponseOf(String string){
        DeletePaymentResponse response = new DeletePaymentResponse();
        response.setResponse(string);
        return response;
    }

    public static PayPaymentResponse payPaymentResponseOf(String string){
        PayPaymentResponse response = new PayPaymentResponse();
        response.setResponse(string);
        return response;
    }

    public static GetPersonResponse personResponseOf(localhost.Person soapPerson){
        GetPersonResponse response = new GetPersonResponse();
        response.setPerson(soapPerson);
        return response;
    }

    public static DeletePersonResponse deletePersonResponseOf(String string){
        DeletePersonResponse response = new DeletePersonResponse();
        response.setResponse(string);
        return response;
    }
}