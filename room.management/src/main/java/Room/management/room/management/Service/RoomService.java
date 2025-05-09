package Room.management.room.management.Service;

import Room.management.room.management.Models.DTO.CreateRoomDTO;
import Room.management.room.management.Models.DTO.DetailsRoomDTO;

import java.util.List;

public interface RoomService {
    CreateRoomDTO createRoom(CreateRoomDTO roomDTO);
    DetailsRoomDTO getRoomById(Long id);
    List<DetailsRoomDTO> getAllRooms();
    CreateRoomDTO updateRoom(Long id, CreateRoomDTO roomDTO);
    void deleteRoom(Long id);
}
