package Room.management.room.management.Repositories;

import Room.management.room.management.Models.Entitys.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepositories extends JpaRepository<Room, Long> {

    List<Room> findAllByHotelId(Long id);
    List<Room> findAllByAvailableAndHotelId(Boolean available, Long id);


}
