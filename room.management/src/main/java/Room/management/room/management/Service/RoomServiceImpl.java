package Room.management.room.management.Service;

import Room.management.room.management.Exceptions.RoomDontExistExp;
import Room.management.room.management.Models.DTO.CreateRoomDTO;
import Room.management.room.management.Models.DTO.DetailsRoomDTO;
import Room.management.room.management.Models.Entitys.Images;
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

         Room room = mapToEntity(roomDTO);
         room.setAvailable(false);
         room.setCreatedAt(LocalDateTime.now());
         room.setUpdatedAt(LocalDateTime.now());
         room.setUserManager(byEmail.get());
         roomRepositories.save(room);
         return "Room created successfully " + roomDTO.getRoomNumber();
    }

    private Room mapToEntity(CreateRoomDTO roomDTO) {
        Room room = new Room();
        room.setRoomNumber(roomDTO.getRoomNumber());
        room.setAvailable(roomDTO.isAvailable());
        room.setCreatedAt(LocalDateTime.now());
        room.setUpdatedAt(LocalDateTime.now());
        room.setFloor(roomDTO.getFloor());
        room.setDescription(roomDTO.getDescription());
        room.setCapacity(roomDTO.getCapacity());
        room.setHotelId(roomDTO.getHotelId());
        room.setPricePerNight(roomDTO.getPricePerNight());
        room.setStatus(roomDTO.getStatus());
        room.setType(roomDTO.getType());
        return room;
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
        Optional<Room> room = roomRepositories.findById(id);
        if (room.isEmpty()) {
            throw new RoomDontExistExp("Room dont exist");
        }
        room.get().setAvailable(true);
        roomRepositories.save(room.get());
        return room.get().getRoomNumber() + " is now not available";
    }

    private DetailsRoomDTO matoToDto(Room room) {
        DetailsRoomDTO map = modelMapper.map(room, DetailsRoomDTO.class);
        List<String> images = map.getImages();
        images.removeAll(map.getImages());
        for (Images image : room.getImages()) {

            map.getImages().add(image.getImageUrl());
        }

        return map;

    }
}
