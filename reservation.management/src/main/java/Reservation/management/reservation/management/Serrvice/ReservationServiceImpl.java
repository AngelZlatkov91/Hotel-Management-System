package Reservation.management.reservation.management.Serrvice;

import Reservation.management.reservation.management.Models.DTO.CreateReservationDTO;
import Reservation.management.reservation.management.Models.DTO.ResponseReservationDTO;
import Reservation.management.reservation.management.Models.Entitys.Reservation;
import Reservation.management.reservation.management.Models.Entitys.User;
import Reservation.management.reservation.management.Repositories.ReservationRepositories;
import Reservation.management.reservation.management.Repositories.UserRepositories;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
//       reservationRepositories.findConflictingReservations(dto.getRoomId(),dto.getCheckInDate(),dto.getCheckOutDate());

        if (byEmail.isEmpty()) {
            User newUser = new User();
            newUser.setEmail(email);
            userRepositories.save(newUser);
        }
        Reservation reservation = mapToCreate(dto);
         reservation.setUser(byEmail.get());
         reservationRepositories.save(reservation);
        return "Reservation has been created";
    }

    private Reservation mapToCreate(CreateReservationDTO dto) {
        Reservation reservation = new Reservation();
        reservation.setCheckInDate(dto.getCheckInDate());
        reservation.setRoomId(dto.getRoomId());
        reservation.setCheckOutDate(dto.getCheckOutDate());
        reservation.setStatus(dto.getStatus());
        reservation.setTotalPrice(dto.getTotalPrice());
        reservation.setCreatedAt(LocalDateTime.now());
        reservation.setUpdatedAt(LocalDateTime.now());
        return reservation;
    }

    @Override
    public ResponseReservationDTO getReservationById(Long id, String email)  {
        Optional<Reservation> byId = reservationRepositories.findById(id);
        if (byId.isEmpty()) {
//            throw new EntityNotFoundException("This reservation does not exist");
        }
        if (!byId.get().getUser().getEmail().equals(email)) {
//           throw new EntityNotFoundException("This User has not this reservation");
        }
        return responseDTo(byId.get());
    }

    private ResponseReservationDTO responseDTo(Reservation reservation) {
        ResponseReservationDTO dto = new ResponseReservationDTO();
        dto.setId(reservation.getId());
        dto.setCheckInDate(reservation.getCheckInDate());
        dto.setStatus(reservation.getStatus());
        dto.setCreatedAt(reservation.getCreatedAt());
        dto.setTotalPrice(reservation.getTotalPrice());
        dto.setRoomId(reservation.getRoomId());
        dto.setCheckOutDate(reservation.getCheckOutDate());
        dto.setUpdatedAt(reservation.getUpdatedAt());
        return dto;
    }

    @Override
    public List<ResponseReservationDTO> getReservationsByUser(String email) {
        Optional<User> byEmail = userRepositories.findByEmail(email);
        if (byEmail.isEmpty()) {
            throw new EntityNotFoundException("This User does not exist");
        }
      return  reservationRepositories
              .findAllByUser(byEmail.get())
              .stream()
              .map(this::responseDTo)
              .toList();
    }

    @Override
    public List<ResponseReservationDTO> getReservationsByRoomId(Long roomId) {

        return reservationRepositories.findAllByRoomId(roomId)
                .stream()
                .map(this::responseDTo)
                .toList();
    }

    @Override
    public boolean isRoomAvailable(Long roomId, LocalDate checkIn, LocalDate checkOut) {
        List<Reservation> conflictingReservations = reservationRepositories.findConflictingReservations(roomId, checkIn, checkOut);
        return !conflictingReservations.isEmpty();
    }


    @Override
    @Transactional
    public void cancelReservation(Long id, String name) {
        Optional<Reservation> byId = reservationRepositories.findById(id);
        if (byId.isPresent() && byId.get().getUser().getEmail().equals(name)) {
            reservationRepositories.deleteById(id);
        }
    }
}
