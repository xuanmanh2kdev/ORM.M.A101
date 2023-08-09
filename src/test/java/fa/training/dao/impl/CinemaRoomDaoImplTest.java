package fa.training.dao.impl;

import fa.training.dao.CinemaRoomDao;
import fa.training.dao.SeatDao;
import fa.training.entities.CinemaRoom;
import fa.training.entities.CinemaRoomDetail;
import fa.training.entities.Seat;
import fa.training.enums.SeatStatusType;
import fa.training.enums.SeatTypeType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CinemaRoomDaoImplTest {

    static CinemaRoomDao cinemaRoomDao;

    @BeforeAll
    static void beforeAll() {
        cinemaRoomDao = new CinemaRoomDaoImpl();
    }

    @Test
    void create_CinemaRoom_Success_Test() {
        CinemaRoom cinemaRoom = new CinemaRoom();
        cinemaRoom.setCinemaRoomName("Room 3");
        cinemaRoom.setSeatQuantity(3);

        List<Seat> seats = new ArrayList<>();
        for (int i = 0; i < cinemaRoom.getSeatQuantity(); i++) {
            Seat seat = new Seat();
            seat.setSeatType(SeatTypeType.NORMAL);
            seat.setSeatStatus(SeatStatusType.BOOKED);
            seat.setCinemaRoom(cinemaRoom);
            seat.setSeatRow(i);
            seat.setSeatColumn("C");
            seats.add(seat);
        }

        cinemaRoom.setSeats(seats);

        CinemaRoomDetail cinemaRoomDetail = new CinemaRoomDetail();
        cinemaRoomDetail.setRoomRate(1500);
        cinemaRoomDetail.setActiveDate(LocalDate.parse("2021-08-01"));
        cinemaRoomDetail.setRoomDescription("Room 3");

        cinemaRoom.setCinemaRoomDetail(cinemaRoomDetail);
        cinemaRoomDetail.setCinemaRoom(cinemaRoom);

        cinemaRoomDao.createCinemaRoom(cinemaRoom);
    }

    @Test
    void get_Cinema_Room_By_Id_Success_Test() {
        assertNotNull(cinemaRoomDao.getCinemaRoomById(1));
    }

    @Test
    void get_Cinema_Room_By_Id_Fail_Test() {
        assertNull(cinemaRoomDao.getCinemaRoomById(100));
    }

    @Test
    void get_All_Cinema_Room_Success_Test() {
        assertTrue(cinemaRoomDao.getAllCinemaRoom().size() > 0);
    }

    @Test
    void get_All_Cinema_Room_Fail_Test() {
        assertTrue(cinemaRoomDao.getAllCinemaRoom().size() == 0);
    }

    @Test
    void update_Cinema_Room_By_Id_Success_Test() {
        CinemaRoom cinemaRoom = new CinemaRoom();
        cinemaRoom.setCinemaRoomID(1);
        cinemaRoom.setCinemaRoomName("Room 7");

        assertNotNull(cinemaRoomDao.updateCinemaRoomById(cinemaRoom));
    }

    @Test
    void update_Cinema_Room_By_Id_Fail_Test() {
        CinemaRoom cinemaRoom = new CinemaRoom();
        cinemaRoom.setCinemaRoomID(1);
        cinemaRoom.setCinemaRoomName("Room 7");

        assertNull(cinemaRoomDao.updateCinemaRoomById(cinemaRoom));
    }

    @Test
    void delete_Cinema_Room_By_Id_Success_Test() {
        assertNotNull(cinemaRoomDao.deleteCinemaRoomById(1));
    }

    @Test
    void delete_Cinema_Room_By_Id_Fail_Test() {
        assertNull(cinemaRoomDao.deleteCinemaRoomById(1));
    }
}