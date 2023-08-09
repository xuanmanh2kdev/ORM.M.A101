package fa.training.dao;

import fa.training.entities.CinemaRoom;
import fa.training.entities.CinemaRoomDetail;

import java.util.List;
import java.util.Optional;

public interface CinemaRoomDetailDao {

    void createCinemaRoomDetail(CinemaRoomDetail cinemaRoomDetail);

    Optional<CinemaRoomDetail> getCinemaRoomDetailById(Integer cinemaRoomDetailID);

    List<CinemaRoomDetail> getAllCinemaRoomDetail();

    Optional<CinemaRoomDetail> updateCinemaRoomDetailById(CinemaRoomDetail cinemaRoomDetail);

    Optional<CinemaRoomDetail> deleteCinemaRoomDetailById(Integer cinemaRoomDetailID);
}
