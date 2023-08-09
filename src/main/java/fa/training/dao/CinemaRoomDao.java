package fa.training.dao;

import fa.training.entities.CinemaRoom;

import java.util.List;
import java.util.Optional;

public interface CinemaRoomDao {

    void createCinemaRoom(CinemaRoom cinemaRoom);

    Optional<CinemaRoom> getCinemaRoomById(Integer cinemaRoomID);

    List<CinemaRoom> getAllCinemaRoom();

    Optional<CinemaRoom> updateCinemaRoomById(CinemaRoom cinemaRoom);

    Optional<CinemaRoom> deleteCinemaRoomById(Integer cinemaRoomID);
}
