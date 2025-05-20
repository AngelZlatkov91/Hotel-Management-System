package Payments.management.payments.management.Service;

import Payments.management.payments.management.Models.DTO.PaymentRequestDTO;
import Payments.management.payments.management.Models.DTO.PaymentResponseDTO;

import java.util.List;

public interface PaymentService {
    PaymentResponseDTO getPaymentById(Long id, String name);

    PaymentResponseDTO makePayment(PaymentRequestDTO request, String name);

    List<PaymentResponseDTO> getAllForUser(String name);

}
