package fa.training.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class CinemaRoom implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cinema_room_id")
    private Integer cinemaRoomID;

    @Column(name = "cinema_room_name", unique = true, nullable = false)
    private String cinemaRoomName;

    @Column(name = "seat_quantity", nullable = false)
    private Integer seatQuantity;

    @OneToMany(mappedBy = "cinemaRoom", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch=FetchType.LAZY)
    @ToString.Exclude
    private List<Seat> seats;


    @OneToOne(mappedBy = "cinemaRoom", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch=FetchType.LAZY)
    @ToString.Exclude
    private CinemaRoomDetail cinemaRoomDetail;
}
