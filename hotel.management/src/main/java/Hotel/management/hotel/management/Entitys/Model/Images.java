package Hotel.management.hotel.management.Entitys.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "images_to_hotel")
public class Images {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, columnDefinition = "TEXT")
    private String image;

    public Images() {
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
