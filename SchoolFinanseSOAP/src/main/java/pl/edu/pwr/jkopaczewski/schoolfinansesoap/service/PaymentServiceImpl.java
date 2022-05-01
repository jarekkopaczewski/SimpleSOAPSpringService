package pl.edu.pwr.jkopaczewski.schoolfinansesoap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import pl.edu.pwr.jkopaczewski.schoolfinansesoap.model.Payment;
import pl.edu.pwr.jkopaczewski.schoolfinansesoap.repository.EventRepository;
import pl.edu.pwr.jkopaczewski.schoolfinansesoap.repository.PaymentRepository;
import pl.edu.pwr.jkopaczewski.schoolfinansesoap.repository.PersonRepository;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    EventRepository eventRepository;

    public Payment addPayment(@RequestBody Payment payment){
        return paymentRepository.save(payment);
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public String deletePayment(int paymentId) {
        paymentRepository.deleteById(paymentId);
        return ResponseEntity.ok().build().toString();
    }

    public String setIsPayed(Integer id) {
        paymentRepository.findById(Math.toIntExact(id))
                .map(payment -> {
                    payment.setPayed(true);
                    return paymentRepository.save(payment);
                });
        return "Payed: " + id;
    }

    public Payment getPaymentById(Integer paymentId) {
        return paymentRepository.getById(paymentId);
    }
}
