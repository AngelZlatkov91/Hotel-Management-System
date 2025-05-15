package Room.management.room.management.Models.DTO;

import java.util.ArrayList;
import java.util.List;

public class AllImagesDTO {

    private List<ImagesDTO> imagesDTOList;

    public AllImagesDTO() {
        this.imagesDTOList = new ArrayList<>();
    }

    public List<ImagesDTO> getImagesDTOList() {
        return imagesDTOList;
    }

    public void setImagesDTOList(List<ImagesDTO> imagesDTOList) {
        this.imagesDTOList = imagesDTOList;
    }
}
