package fa.training.dao.impl;

import fa.training.dao.CinemaRoomDetailDao;
import fa.training.entities.CinemaRoomDetail;
import fa.training.utils.XmlConnectionConfig;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class CinemaRoomDetailDaoImpl implements CinemaRoomDetailDao {
    @Override
    public void createCinemaRoomDetail(CinemaRoomDetail cinemaRoomDetail) {
        try(Session session = XmlConnectionConfig.getSession()) {
            session.beginTransaction();
            session.persist(cinemaRoomDetail);
            session.getTransaction().commit();
        }
    }

    @Override
    public Optional<CinemaRoomDetail> getCinemaRoomDetailById(Integer cinemaRoomDetailID) {
        try(Session session = XmlConnectionConfig.getSession()) {
            CinemaRoomDetail cinemaRoomDetail = session.find(CinemaRoomDetail.class, cinemaRoomDetailID);
            return Optional.ofNullable(cinemaRoomDetail);
        }
    }

    @Override
    public List<CinemaRoomDetail> getAllCinemaRoomDetail() {
        try(Session session = XmlConnectionConfig.getSession()) {
            return session.createQuery("SELECT c FROM CinemaRoomDetail c", CinemaRoomDetail.class).getResultList();
        }
    }

    @Override
    public Optional<CinemaRoomDetail> updateCinemaRoomDetailById(CinemaRoomDetail cinemaRoomDetail) {
        try (Session session = XmlConnectionConfig.getSession()) {
            session.beginTransaction();
            CinemaRoomDetail cinemaRoomDetail2 = session.find(CinemaRoomDetail.class, cinemaRoomDetail.getCinemaRoomDetailID());
            if (cinemaRoomDetail2 == null) {
                return null;
            }else {
                cinemaRoomDetail2.setRoomRate(cinemaRoomDetail.getRoomRate());
                cinemaRoomDetail2.setActiveDate(cinemaRoomDetail.getActiveDate());
                cinemaRoomDetail2.setRoomDescription(cinemaRoomDetail.getRoomDescription());

                session.merge(cinemaRoomDetail2);
                session.getTransaction().commit();
                return Optional.of(cinemaRoomDetail);
            }
        }
    }

    @Override
    public Optional<CinemaRoomDetail> deleteCinemaRoomDetailById(Integer cinemaRoomDetailID) {
        try(Session session = XmlConnectionConfig.getSession()) {
            session.beginTransaction();
            CinemaRoomDetail cinemaRoomDetail = session.find(CinemaRoomDetail.class, cinemaRoomDetailID);
            if (cinemaRoomDetail == null) {
                return null;
            }else {
                session.remove(cinemaRoomDetail);
                session.getTransaction().commit();
                return Optional.of(cinemaRoomDetail);
            }
        }
    }
}
