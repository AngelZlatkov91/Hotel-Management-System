package Reservation.management.reservation.management.Models.Entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table
public class User extends BaseEntity{
    private String email;
}
