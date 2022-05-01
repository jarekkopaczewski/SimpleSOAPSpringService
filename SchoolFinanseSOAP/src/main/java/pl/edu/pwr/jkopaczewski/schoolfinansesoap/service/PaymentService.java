package pl.edu.pwr.jkopaczewski.schoolfinansesoap.service;

import pl.edu.pwr.jkopaczewski.schoolfinansesoap.model.Payment;

import java.util.List;

public interface PaymentService {
    Payment addPayment(Payment payment);
    List<Payment> getAllPayments();
    String deletePayment(int paymentId);
    String setIsPayed(Integer id);
    Payment getPaymentById(Integer paymentId);
}
