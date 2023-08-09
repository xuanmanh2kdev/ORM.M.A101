package fa.training.dao;

import fa.training.entities.Seat;

import java.util.List;
import java.util.Optional;

public interface SeatDao {

    void createSeat(Seat seat);

    Optional<Seat> getSeatById(Integer seatID);

    List<Seat> getAllSeat();

    Optional<Seat> updateSeatById(Seat seat);

    Optional<Seat> deleteSeatById(Integer seatID);
}
