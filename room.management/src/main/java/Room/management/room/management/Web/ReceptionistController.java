package Room.management.room.management.Web;

import Room.management.room.management.Service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/receptionist")
public class ReceptionistController {

   private final RoomService roomService;

    public ReceptionistController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PutMapping
    public ResponseEntity<String> availableRoom(@PathVariable boolean available) {

        return ResponseEntity.ok("Available room: " + available);
    }

}
