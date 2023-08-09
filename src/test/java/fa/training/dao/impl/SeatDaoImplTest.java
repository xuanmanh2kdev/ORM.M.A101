package fa.training.dao.impl;

import fa.training.dao.SeatDao;
import fa.training.entities.Seat;
import fa.training.enums.SeatStatusType;
import fa.training.enums.SeatTypeType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SeatDaoImplTest {

    static SeatDao seatDao;

    @BeforeAll
    static void beforeAll() {
        seatDao = new SeatDaoImpl();
    }

    @Test
    void get_Seat_By_Id_Success_Test(){
        assertNotNull(seatDao.getSeatById(1));
    }

    @Test
    void get_Seat_By_Id_Fail_Test(){
        assertNull(seatDao.getSeatById(100));
    }

    @Test
    void get_All_Seat_Success_Test(){
        assertNotNull(seatDao.getAllSeat());
    }

    @Test
    void get_All_Seat_Fail_Test(){
        assertNull(seatDao.getAllSeat());
    }


    @Test
    void update_Seat_By_Id_Success_Test(){
        Seat seat = new Seat();
        seat.setSeatID(1);
        seat.setSeatType(SeatTypeType.VIP);
        seat.setSeatStatus(SeatStatusType.AVAILABLE);
        seat.setSeatRow(1);
        seat.setSeatColumn("A");
        assertNotNull(seatDao.updateSeatById(seat));
    }

    @Test
    void update_Seat_By_Id_Fail_Test(){
        Seat seat = new Seat();
        seat.setSeatID(100);
        seat.setSeatType(SeatTypeType.VIP);
        seat.setSeatStatus(SeatStatusType.AVAILABLE);
        seat.setSeatRow(1);
        seat.setSeatColumn("A");
        assertNull(seatDao.updateSeatById(seat));
    }

    @Test
    void delete_Seat_By_Id_Success_Test(){
        assertNotNull(seatDao.deleteSeatById(1));
    }

    @Test
    void delete_Seat_By_Id_Fail_Test(){
        assertNull(seatDao.deleteSeatById(100));
    }
}
