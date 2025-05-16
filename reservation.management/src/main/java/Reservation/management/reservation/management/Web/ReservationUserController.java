package Reservation.management.reservation.management.Web;

import Reservation.management.reservation.management.Models.DTO.CreateReservationDTO;
import Reservation.management.reservation.management.Models.DTO.ResponseReservationDTO;
import Reservation.management.reservation.management.Serrvice.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationUserController {


    private final ReservationService reservationService;

    public ReservationUserController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public ResponseEntity<String> createReservation(@RequestBody CreateReservationDTO reservation, Authentication authentication) {
        String reservation1 = reservationService.createReservation(reservation, authentication.getName());
        return ResponseEntity.ok(reservation1);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseReservationDTO> getReservation(@PathVariable Long id, Authentication authentication) {
        ResponseReservationDTO reservationById = reservationService.getReservationById(id, authentication.getName());
        return ResponseEntity.ok(reservationById);
    }

    @GetMapping("/user/all")
    public ResponseEntity<List<ResponseReservationDTO>> getAllReservations(Authentication authentication) {
      return ResponseEntity.ok(reservationService.getReservationsByUser(authentication.getName()));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseReservationDTO> updateReservation (@PathVariable Long id, @RequestBody CreateReservationDTO createReservationDTO, Authentication authentication) {
        //TODO
        ResponseReservationDTO reservationById = new ResponseReservationDTO();
        return ResponseEntity.ok(reservationById);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteReservation(@PathVariable Long id, Authentication authentication) {
        reservationService.cancelReservation(id,authentication.getName());
        return ResponseEntity.ok("Deleted");
    }

    @GetMapping("/available")
    public ResponseEntity<Boolean> checkAvailability(@RequestParam Long roomId,
                                                     @RequestParam LocalDate checkIn,
                                                     @RequestParam LocalDate checkOut) {
        return ResponseEntity.ok(reservationService.isRoomAvailable(roomId, checkIn, checkOut));
    }



}
