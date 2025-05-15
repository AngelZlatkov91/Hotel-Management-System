package Room.management.room.management.Repositories;


import Room.management.room.management.Models.Entitys.UserManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserManagerRepository extends JpaRepository<UserManager, Long> {
    Optional<UserManager> findByEmail(String email);
}
