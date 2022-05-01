package pl.edu.pwr.jkopaczewski.schoolfinansesoap.endpoint;

import localhost.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pl.edu.pwr.jkopaczewski.schoolfinansesoap.service.PaymentService;
import pl.edu.pwr.jkopaczewski.schoolfinansesoap.soap.ResponseFactory;
import pl.edu.pwr.jkopaczewski.schoolfinansesoap.soap.SoapFactory;

@Endpoint
public class PaymentEndpoint {
    private static final String NAMESPACE_URI = "localhost";
    @Autowired
    PaymentService paymentService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPaymentRequest")
    @ResponsePayload
    public GetPaymentResponse getPaymentResponse(@RequestPayload GetPaymentRequest request) {
        return ResponseFactory.paymentResponseOf(SoapFactory.paymentOf(paymentService.getPaymentById(request.getPaymentId())));
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deletePaymentRequest")
    @ResponsePayload
    public DeletePaymentResponse deletePaymentResponse(@RequestPayload DeletePaymentRequest request) {
        return ResponseFactory.deletePaymentResponseOf(paymentService.deletePayment(request.getPaymentId()));
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "payPaymentRequest")
    @ResponsePayload
    public PayPaymentResponse payPaymentResponse(@RequestPayload PayPaymentRequest request) {
        return ResponseFactory.payPaymentResponseOf(paymentService.setIsPayed(request.getPaymentId()));
    }
}
