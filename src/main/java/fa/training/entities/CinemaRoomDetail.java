package fa.training.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
public class CinemaRoomDetail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cinema_room_detail_id")
    private Integer cinemaRoomDetailID;

    @Column(name = "room_rate", nullable = false)
    private Integer roomRate;

    @Column(name = "active_date", nullable = false)
    private LocalDate activeDate;

    @Column(name = "room_description", length = 250, nullable = false)
    private String roomDescription;

    @OneToOne(optional = false)
    @JoinColumn(name = "cinema_room_id")
    @Column(unique = true)
    @ToString.Exclude
    private CinemaRoom cinemaRoom;
}
