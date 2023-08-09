package fa.training.dao.impl;

import fa.training.dao.CinemaRoomDao;
import fa.training.dao.CinemaRoomDetailDao;
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

class TestAll {

    static SeatDao seatDao;
    static CinemaRoomDao cinemaRoomDao;
    static CinemaRoomDetailDao cinemaRoomDetailDao;

    @BeforeAll
    static void beforeAll() {
        seatDao = new SeatDaoImpl();
        cinemaRoomDao = new CinemaRoomDaoImpl();
        cinemaRoomDetailDao = new CinemaRoomDetailDaoImpl();
    }

    @Test
    void create_DB_Test() {
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

        assertDoesNotThrow(() -> cinemaRoomDao.createCinemaRoom(cinemaRoom));
    }

    @Test
    void get_Cinema_Room_By_Id_Test() {
        System.out.println(cinemaRoomDao.getCinemaRoomById(1));
    }

    @Test
    void get_All_Cinema_Room_Test() {
        System.out.println(cinemaRoomDao.getAllCinemaRoom());
    }

    @Test
    void update_Cinema_Room_By_Id_Test() {
        CinemaRoom cinemaRoom = new CinemaRoom();
        cinemaRoom.setCinemaRoomID(1);
        cinemaRoom.setCinemaRoomName("Room 7");

        cinemaRoomDao.updateCinemaRoomById(cinemaRoom);
    }

    @Test
    void delete_Cinema_Room_By_Id() {
        System.out.println(cinemaRoomDao.deleteCinemaRoomById(1));
    }

    @Test
    void get_Seat_By_Id_Test(){
        System.out.println(seatDao.getSeatById(2));
    }

    @Test
    void get_All_Seat_Test(){
        System.out.println(seatDao.getAllSeat());
    }

    @Test
    void update_Seat_By_Id_Test(){
        Seat seat = new Seat();
        seat.setSeatID(2);
        seat.setSeatType(SeatTypeType.VIP);
        seat.setSeatStatus(SeatStatusType.AVAILABLE);
        seat.setSeatRow(1);
        seat.setSeatColumn("A");
        seatDao.updateSeatById(seat);
    }

    @Test
    void delete_Seat_By_Id_Test(){
        System.out.println(seatDao.deleteSeatById(2));
    }

    @Test
    void get_Cinema_Room_Detail_By_Id_Test(){
        System.out.println(cinemaRoomDetailDao.getCinemaRoomDetailById(1));
    }

    @Test
    void get_All_Cinema_Room_Detail_Test(){
        System.out.println(cinemaRoomDetailDao.getAllCinemaRoomDetail());
    }

    @Test
    void update_Cinema_Room_Detail_By_Id_Test(){
        CinemaRoomDetail cinemaRoomDetail = new CinemaRoomDetail();
        cinemaRoomDetail.setCinemaRoomDetailID(1);
        cinemaRoomDetail.setRoomRate(2000);
        cinemaRoomDetail.setActiveDate(LocalDate.parse("2022-08-01"));
        cinemaRoomDetail.setRoomDescription("Room 5");
        cinemaRoomDetailDao.updateCinemaRoomDetailById(cinemaRoomDetail);
    }

    @Test
    void delete_Cinema_Room_Detail_By_Id_Test(){
        System.out.println(cinemaRoomDetailDao.deleteCinemaRoomDetailById(1));
    }
}