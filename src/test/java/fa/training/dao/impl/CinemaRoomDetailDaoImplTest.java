package fa.training.dao.impl;

import fa.training.dao.CinemaRoomDetailDao;
import fa.training.entities.CinemaRoomDetail;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class CinemaRoomDetailDaoImplTest {

    static CinemaRoomDetailDao cinemaRoomDetailDao;

    @BeforeAll
    static void beforeAll() {
        cinemaRoomDetailDao = new CinemaRoomDetailDaoImpl();
    }

    @Test
    void get_Cinema_Room_Detail_By_Id_Success_Test(){
        assertNotNull(cinemaRoomDetailDao.getCinemaRoomDetailById(1));
    }

    @Test
    void get_Cinema_Room_Detail_By_Id_Fail_Test(){
        assertNull(cinemaRoomDetailDao.getCinemaRoomDetailById(1));
    }

    @Test
    void get_All_Cinema_Room_Detail_Success_Test(){
        assertTrue(cinemaRoomDetailDao.getAllCinemaRoomDetail().size() > 0);
    }

    @Test
    void get_All_Cinema_Room_Detail_Fail_Test(){
        assertTrue(cinemaRoomDetailDao.getAllCinemaRoomDetail().size() == 0);
    }

    @Test
    void update_Cinema_Room_Detail_By_Id_Success_Test(){
        CinemaRoomDetail cinemaRoomDetail = new CinemaRoomDetail();
        cinemaRoomDetail.setCinemaRoomDetailID(1);
        cinemaRoomDetail.setRoomRate(2000);
        cinemaRoomDetail.setActiveDate(LocalDate.parse("2022-08-01"));
        cinemaRoomDetail.setRoomDescription("Room 5");
        assertNotNull(cinemaRoomDetailDao.updateCinemaRoomDetailById(cinemaRoomDetail));
    }

    @Test
    void update_Cinema_Room_Detail_By_Id_Fail_Test(){
        CinemaRoomDetail cinemaRoomDetail = new CinemaRoomDetail();
        cinemaRoomDetail.setCinemaRoomDetailID(100);
        cinemaRoomDetail.setRoomRate(2000);
        cinemaRoomDetail.setActiveDate(LocalDate.parse("2022-08-01"));
        cinemaRoomDetail.setRoomDescription("Room 5");
        assertNull(cinemaRoomDetailDao.updateCinemaRoomDetailById(cinemaRoomDetail));
    }

    @Test
    void delete_Cinema_Room_Detail_By_Id_Success_Test(){
        assertNotNull(cinemaRoomDetailDao.deleteCinemaRoomDetailById(1));
    }

    @Test
    void delete_Cinema_Room_Detail_By_Id_Fail_Test(){
        assertNull(cinemaRoomDetailDao.deleteCinemaRoomDetailById(100));
    }
}
