package Room.management.room.management.Repositories;

import Room.management.room.management.Models.Entitys.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagesRepositories extends JpaRepository<Images, Long> {

}
