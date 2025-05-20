package Payments.management.payments.management.Web;

import Payments.management.payments.management.Models.DTO.PaymentRequestDTO;
import Payments.management.payments.management.Models.DTO.PaymentResponseDTO;
import Payments.management.payments.management.Service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public ResponseEntity<PaymentResponseDTO> makePayment(@RequestBody PaymentRequestDTO request, Authentication authentication) {
        PaymentResponseDTO response = paymentService.makePayment(request, authentication.getName());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentResponseDTO> getPayment(@PathVariable Long id, Authentication authentication) {
        return ResponseEntity.ok(paymentService.getPaymentById(id, authentication.getName()));
    }

    @GetMapping("/all")
    public ResponseEntity<List<PaymentResponseDTO>> getAllPayments(Authentication authentication) {
        return ResponseEntity.ok(paymentService.getAllForUser(authentication.getName()));

    }

}
