package Payments.management.payments.management.Service;

import Payments.management.payments.management.Models.DTO.PaymentRequestDTO;
import Payments.management.payments.management.Models.DTO.PaymentResponseDTO;
import Payments.management.payments.management.Models.Payment;
import Payments.management.payments.management.Models.User;
import Payments.management.payments.management.Repositories.PaymentRepositories;
import Payments.management.payments.management.Repositories.UserRepositories;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepositories paymentRepositories;
    private final UserRepositories userRepositories;

    public PaymentServiceImpl(PaymentRepositories paymentRepositories, UserRepositories userRepositories) {
        this.paymentRepositories = paymentRepositories;
        this.userRepositories = userRepositories;
    }

    @Override
    public PaymentResponseDTO makePayment(PaymentRequestDTO request, String email) {

        Optional<User> byEmail = userRepositories.findByEmail(email);
        if (byEmail.isEmpty()) {
            User newUser = new User();
            newUser.setEmail(email);
            userRepositories.save(newUser);
        }
        Payment payment = new Payment();
        payment.setAmount(request.getAmount());
        payment.setMethod(request.getMethod());
        payment.setReservationId(request.getReservationId());


        return null;
    }



    @Override
    public PaymentResponseDTO getPaymentById(Long id, String email) {
        Optional<User> byEmail = userRepositories.findByEmail(email);
        Optional<Payment> byIdAndUser = paymentRepositories.findById(id);
        if (byEmail.isPresent() && byIdAndUser.isPresent()) {
            if (byIdAndUser.get().getUser().getEmail().equals(email)) {

            }
        }
        return null;
    }





    @Override
    public List<PaymentResponseDTO> getAllForUser(String name) {
        return List.of();
    }
}
