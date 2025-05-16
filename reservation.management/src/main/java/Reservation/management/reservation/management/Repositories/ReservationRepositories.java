package Reservation.management.reservation.management.Repositories;

import Reservation.management.reservation.management.Models.Entitys.Reservation;
import Reservation.management.reservation.management.Models.Entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepositories extends JpaRepository<Reservation, Long> {

    List<Reservation> findAllByUser(User user);

    List<Reservation> findAllByRoomId(Long roomId);


    @Query("select r from Reservation as r where r.roomId = :roomId AND r.status <> 'CANCEKKED' " +
    "AND r.checkInDate < :checkOut AND r.checkOutDate > :checkIn")
    List<Reservation> findConflictingReservations(Long roomId,
                                                  LocalDate checkIn,
                                                  LocalDate checkOut);

}
