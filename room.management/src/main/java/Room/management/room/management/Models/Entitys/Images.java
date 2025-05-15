package Room.management.room.management.Models.Entitys;

import jakarta.persistence.*;

@Entity
@Table(name = "images_for_rooms")
public class Images extends BaseEntity {


    @Column(columnDefinition = "TEXT")
    private String imageUrl;
    @ManyToOne
    private Room roomId;

    public Images() {}


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Room getRoomId() {
        return roomId;
    }

    public void setRoomId(Room roomId) {
        this.roomId = roomId;
    }
}
