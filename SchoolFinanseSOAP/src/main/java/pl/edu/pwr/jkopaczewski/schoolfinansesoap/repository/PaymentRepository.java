package pl.edu.pwr.jkopaczewski.schoolfinansesoap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pwr.jkopaczewski.schoolfinansesoap.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
