package fa.training.entities;

import fa.training.enums.SeatStatusType;
import fa.training.enums.SeatTypeType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
public class Seat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seat_id")
    private Integer seatID;

    @Column(name = "seat_column", nullable = false)
    private String seatColumn;

    @Column(name = "seat_row", nullable = false)
    private Integer seatRow;

    @Enumerated(EnumType.STRING)
    @Column(name = "seat_status", nullable = false)
    private SeatStatusType seatStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "seat_type", nullable = false)
    private SeatTypeType seatType;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cinema_room_id")
    @ToString.Exclude
    private CinemaRoom cinemaRoom;
}
