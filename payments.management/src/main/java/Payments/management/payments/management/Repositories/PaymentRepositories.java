package Payments.management.payments.management.Repositories;

import Payments.management.payments.management.Models.Payment;
import Payments.management.payments.management.Models.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepositories extends JpaRepository<Payment, Long> {

    Optional<Payment> findByReservationId(Long id);
    Optional<Payment> findById(Long id);

    List<Payment> findAllByUser(User user);


}
