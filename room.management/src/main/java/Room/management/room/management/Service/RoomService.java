package Room.management.room.management.Service;

import Room.management.room.management.Models.DTO.CreateRoomDTO;
import Room.management.room.management.Models.DTO.DetailsRoomDTO;

import java.util.List;

public interface RoomService {

    String createRoom(CreateRoomDTO roomDTO, String email, String role);

    DetailsRoomDTO getRoomById(Long id);

    List<DetailsRoomDTO> getAllRooms(Long id);

    String updateRoom(Long id, CreateRoomDTO roomDTO, String email);

    void deleteRoom(Long id, String email);

    List<DetailsRoomDTO> getAvailableRooms(Long id);

    String setAvailable(Long id);

}
