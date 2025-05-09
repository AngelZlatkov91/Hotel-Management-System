package Room.management.room.management.Web;
import Room.management.room.management.Models.DTO.CreateRoomDTO;
import Room.management.room.management.Service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/manager/rooms")
public class ManagerController {

    private final RoomService roomService;

    public ManagerController(RoomService roomService) {
        this.roomService = roomService;
    }


    @PostMapping
    public ResponseEntity<String>addRoom(@RequestBody CreateRoomDTO room, Authentication authentication) {
        return ResponseEntity.ok("Successfully added room");
    }

    @PutMapping
    public ResponseEntity<String> updateRoom(@RequestBody CreateRoomDTO room, Authentication authentication) {
        return ResponseEntity.ok("Successfully updated room");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteRoom(@PathVariable Long id) {
        return ResponseEntity.ok("Successfully deleted room");
    }


}
