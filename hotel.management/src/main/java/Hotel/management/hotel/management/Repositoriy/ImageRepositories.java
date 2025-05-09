package Hotel.management.hotel.management.Repositoriy;

import Hotel.management.hotel.management.Entitys.Model.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ImageRepositories extends JpaRepository<Images, Long> {
}
