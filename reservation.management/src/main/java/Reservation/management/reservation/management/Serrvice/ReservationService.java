package Reservation.management.reservation.management.Serrvice;

import Reservation.management.reservation.management.Models.DTO.CreateReservationDTO;
import Reservation.management.reservation.management.Models.DTO.ResponseReservationDTO;

import java.time.LocalDate;
import java.util.List;

public interface ReservationService {

    String createReservation(CreateReservationDTO dto, String email);
    ResponseReservationDTO getReservationById(Long id,String email);
    List<ResponseReservationDTO > getReservationsByUser(String  email);
    List<ResponseReservationDTO > getReservationsByRoomId(Long roomId);
    boolean isRoomAvailable(Long roomId, LocalDate checkIn, LocalDate checkOut);


    void cancelReservation(Long id, String name);

}
