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

    @GetMapping
    public ResponseEntity<List<DetailsRoomDTO>> getAllByHotel (String hotel) {


        return ResponseEntity.ok(List.of());
    }

    @GetMapping("/id")
    public ResponseEntity<DetailsRoomDTO> getAllRoomByID (@PathVariable Long id) {
         DetailsRoomDTO detailsRoomDTO = new DetailsRoomDTO();

        return ResponseEntity.ok(detailsRoomDTO);
    }

    @GetMapping("/available")
    public ResponseEntity<List<DetailsRoomDTO>> getAllByHotelByAvailable (String hotel) {

        return ResponseEntity.ok(List.of());
    }

}
