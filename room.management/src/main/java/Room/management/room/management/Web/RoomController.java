package Room.management.room.management.Web;
import Room.management.room.management.Models.DTO.DetailsRoomDTO;
import Room.management.room.management.Service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/byHotel/{id}")
    public ResponseEntity<List<DetailsRoomDTO>> getAllByHotel (@PathVariable Long id) {
        return ResponseEntity.ok(roomService.getAllRooms(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailsRoomDTO> getAllRoomByID (@PathVariable Long id) {
        return ResponseEntity.ok(roomService.getRoomById(id));
    }

    @GetMapping("/available/{id}")
    public ResponseEntity<List<DetailsRoomDTO>> getAllByHotelByAvailable (@PathVariable Long id) {
        return ResponseEntity.ok(roomService.getAvailableRooms(id));
    }

}
