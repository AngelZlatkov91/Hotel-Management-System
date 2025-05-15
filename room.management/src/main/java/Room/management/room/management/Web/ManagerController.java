package Room.management.room.management.Web;
import Room.management.room.management.Models.DTO.AllImagesDTO;
import Room.management.room.management.Models.DTO.CreateRoomDTO;
import Room.management.room.management.Service.ImagesService;
import Room.management.room.management.Service.RoomService;
import Room.management.room.management.Service.UserManagerService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;

@RestController
@RequestMapping("/api/manager/rooms")
public class ManagerController {

    private final RoomService roomService;
    private final UserManagerService userService;
    private final ImagesService imagesService;

    public ManagerController(RoomService roomService, UserManagerService userService, ImagesService imagesService) {
        this.roomService = roomService;
        this.userService = userService;
        this.imagesService = imagesService;
    }




    @PostMapping
    public ResponseEntity<String> addRoom(@RequestBody CreateRoomDTO roomDto, Authentication authentication) {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        userService.addUserManager(authentication.getName(),authorities.toString());
        String room = roomService.createRoom(roomDto,authentication.getName(),authorities.toString());
        return ResponseEntity.ok(room);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateRoom(@PathVariable Long id,@RequestBody CreateRoomDTO roomDto, Authentication authentication) {
        String room = roomService.updateRoom(id, roomDto,authentication.getName());
        return ResponseEntity.ok("Successfully updated room " + room);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRoom(@PathVariable Long id,Authentication authentication) {
        roomService.deleteRoom(id,authentication.getName());
        return ResponseEntity.ok("Successfully deleted room");
    }

    @PostMapping("/images/{id}")
    public ResponseEntity<String> addImage(@PathVariable Long id , @RequestParam AllImagesDTO images) {
        imagesService.addImagesToHotelRooms(images,id);
        return ResponseEntity.ok("successfully add image");

    }





}
