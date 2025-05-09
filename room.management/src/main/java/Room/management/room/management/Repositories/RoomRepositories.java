package Room.management.room.management.Repositories;

import Room.management.room.management.Models.Entitys.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepositories extends JpaRepository<Room, Long> {
}
