package Hotel.management.hotel.management.Repositoriy;

import Hotel.management.hotel.management.Entitys.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositories extends JpaRepository<User, Long> {
}
