package Reservation.management.reservation.management.Repositories;

import Reservation.management.reservation.management.Models.Entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositories extends JpaRepository<User, Long> {
}
