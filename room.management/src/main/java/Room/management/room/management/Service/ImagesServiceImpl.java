package Room.management.room.management.Service;

import Room.management.room.management.Models.DTO.AllImagesDTO;
import Room.management.room.management.Models.DTO.ImagesDTO;
import Room.management.room.management.Models.Entitys.Images;
import Room.management.room.management.Models.Entitys.Room;
import Room.management.room.management.Repositories.ImagesRepositories;
import Room.management.room.management.Repositories.RoomRepositories;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ImagesServiceImpl implements ImagesService {

    private final ImagesRepositories imagesRepositories;
    private final RoomRepositories roomRepositories;

    public ImagesServiceImpl(ImagesRepositories imagesRepositories, RoomRepositories roomRepositories) {
        this.imagesRepositories = imagesRepositories;
        this.roomRepositories = roomRepositories;
    }

    @Override
    @Transactional
    public void addImagesToHotelRooms(AllImagesDTO allImagesDTO , Long id) {
        Optional<Room> byId = roomRepositories.findById(id);
        if (byId.isEmpty()) {
            throw new RuntimeException();
        }
        List<Images> allImages = mapImages(allImagesDTO, byId.get());
           byId.get().getImages().addAll(allImages);
           roomRepositories.save(byId.get());
    }

    private List<Images> mapImages(AllImagesDTO allImagesDTO, Room room) {
       List<Images> images = new ArrayList<>();
        allImagesDTO.getImagesDTOList().forEach(image -> {
            Images singleImage = new Images();
            singleImage.setImageUrl(image.getImages());
            singleImage.setRoomId(room);
            images.add(singleImage);
            imagesRepositories.save(singleImage);
        });
        return images;
    }

    @Override
    public List<ImagesDTO> getAllImagesDTO(Long id) {
        return List.of();
    }

    @Override
    public void deleteImages(Long id) {

    }
}
