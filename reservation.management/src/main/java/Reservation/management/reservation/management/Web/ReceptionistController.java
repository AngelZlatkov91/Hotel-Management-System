package Reservation.management.reservation.management.Web;

import Reservation.management.reservation.management.Models.DTO.ResponseReservationDTO;
import Reservation.management.reservation.management.Serrvice.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/receptionist")
public class ReceptionistController {

    private final ReservationService reservationService;

    public ReceptionistController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<ResponseReservationDTO>> getAllByRoom(@PathVariable Long id) {
       return ResponseEntity.ok(reservationService.getReservationsByRoomId(id));
    }
}
