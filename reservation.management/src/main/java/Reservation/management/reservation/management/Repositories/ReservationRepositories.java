package Reservation.management.reservation.management.Repositories;

import Reservation.management.reservation.management.Models.Entitys.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepositories extends JpaRepository<Reservation, Long> {

}
