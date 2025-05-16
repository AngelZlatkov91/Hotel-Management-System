package Reservation.management.reservation.management.Serrvice;

import Reservation.management.reservation.management.Models.DTO.CreateReservationDTO;
import Reservation.management.reservation.management.Models.DTO.ResponseReservationDTO;
import Reservation.management.reservation.management.Models.Entitys.Reservation;
import Reservation.management.reservation.management.Models.Entitys.User;
import Reservation.management.reservation.management.Repositories.ReservationRepositories;
import Reservation.management.reservation.management.Repositories.UserRepositories;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepositories reservationRepositories;
    private final UserRepositories userRepositories;

    public ReservationServiceImpl(ReservationRepositories reservationRepositories, UserRepositories userRepositories) {
        this.reservationRepositories = reservationRepositories;
        this.userRepositories = userRepositories;
    }

    @Override
    public String createReservation(CreateReservationDTO dto, String email) {
        Optional<User> byEmail = userRepositories.findByEmail(email);
       reservationRepositories.findConflictingReservations(dto.getRoomId(),dto.getCheckInDate(),dto.getCheckOutDate());

        if (byEmail.isEmpty()) {
            User newUser = new User();
            newUser.setEmail(email);
            userRepositories.save(newUser);
        }
        Reservation reservation = mapToCreate(dto);




        return "";
    }

    private Reservation mapToCreate(CreateReservationDTO dto) {
        Reservation reservation = new Reservation();
//        reservation.setCreatedAt();
        return null;
    }

    @Override
    public ResponseReservationDTO getReservationById(Long id, String email) {
        return null;
    }

    @Override
    public List<ResponseReservationDTO> getReservationsByUser(String email) {
        return List.of();
    }

    @Override
    public List<ResponseReservationDTO> getReservationsByRoomId(Long roomId) {
        return List.of();
    }

    @Override
    public boolean isRoomAvailable(Long roomId, LocalDate checkIn, LocalDate checkOut) {
        return false;
    }


    @Override
    public void cancelReservation(Long id, String name) {

    }
}
