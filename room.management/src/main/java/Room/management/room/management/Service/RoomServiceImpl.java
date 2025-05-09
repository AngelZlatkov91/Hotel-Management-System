package Room.management.room.management.Service;

import Room.management.room.management.Models.DTO.CreateRoomDTO;
import Room.management.room.management.Models.DTO.DetailsRoomDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Override
    public CreateRoomDTO createRoom(CreateRoomDTO roomDTO) {
        return null;
    }

    @Override
    public DetailsRoomDTO getRoomById(Long id) {
        return null;
    }

    @Override
    public List<DetailsRoomDTO> getAllRooms() {
        return List.of();
    }

    @Override
    public CreateRoomDTO updateRoom(Long id, CreateRoomDTO roomDTO) {
        return null;
    }

    @Override
    public void deleteRoom(Long id) {

    }
}
