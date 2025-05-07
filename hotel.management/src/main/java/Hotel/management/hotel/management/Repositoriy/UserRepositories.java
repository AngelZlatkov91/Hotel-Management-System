package Hotel.management.hotel.management.Repositoriy;

import Hotel.management.hotel.management.Entitys.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositories extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
