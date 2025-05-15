package Room.management.room.management.Service;

import Room.management.room.management.Models.DTO.CreateRoomDTO;
import Room.management.room.management.Models.DTO.DetailsRoomDTO;
import Room.management.room.management.Models.Entitys.Room;
import Room.management.room.management.Models.Entitys.UserManager;
import Room.management.room.management.Repositories.RoomRepositories;
import Room.management.room.management.Repositories.UserManagerRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepositories roomRepositories;
    private final ModelMapper modelMapper;

    private final UserManagerRepository userManagerRepository;

    public RoomServiceImpl(RoomRepositories roomRepositories, ModelMapper modelMapper, UserManagerRepository userManagerRepository) {
        this.roomRepositories = roomRepositories;
        this.modelMapper = modelMapper;
        this.userManagerRepository = userManagerRepository;
    }

    @Override
    public String createRoom(CreateRoomDTO roomDTO, String email, String role) {
        Optional<UserManager> byEmail = userManagerRepository.findByEmail(email);
        if (!byEmail.get().getRole().equals(role)) {

            return "";
        }

         Room room = modelMapper.map(roomDTO, Room.class);
         room.setAvailable(false);
         room.setCreatedAt(LocalDateTime.now());
         room.setUpdatedAt(LocalDateTime.now());
         room.setUserManager(byEmail.get());
         roomRepositories.save(room);
         return "Room created successfully " + roomDTO.getRoomNumber();
    }

    @Override
    public DetailsRoomDTO getRoomById(Long id) {
        Optional<Room> byId = roomRepositories.findById(id);
        return matoToDto(byId.get());
    }

    @Override
    public List<DetailsRoomDTO> getAllRooms(Long id) {
       return  roomRepositories
               .findAllByHotelId(id)
               .stream()
               .map(this::matoToDto)
               .toList();
    }

    @Override
    @Transactional
    public String updateRoom(Long id, CreateRoomDTO roomDTO, String email) {

        return null;
    }

    @Override
    @Transactional
    public void deleteRoom(Long id, String email) {
        Optional<UserManager> byEmail = userManagerRepository.findByEmail(email);
        Optional<Room> byId = roomRepositories.findById(id);
        if (byId.get().getUserManager().equals(byEmail.get())) {
            roomRepositories.delete(byId.get());
        }
    }

    @Override
    public List<DetailsRoomDTO> getAvailableRooms(Long id) {
      return roomRepositories
              .findAllByAvailableAndHotelId(false,  id)
              .stream()
              .map(this::matoToDto)
              .toList();

    }

    @Override
    @Transactional
    public String setAvailable(Long id) {
        Room room = roomRepositories.findById(id).get();
        room.setAvailable(true);
        roomRepositories.save(room);
        return room.getRoomNumber() + " is now not available";
    }

    private DetailsRoomDTO matoToDto(Room room) {
        DetailsRoomDTO map = modelMapper.map(room, DetailsRoomDTO.class);

        return modelMapper.map(room, DetailsRoomDTO.class);

    }
}
