package fa.training.dao.impl;

import fa.training.dao.CinemaRoomDao;
import fa.training.entities.CinemaRoom;
import fa.training.utils.XmlConnectionConfig;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class CinemaRoomDaoImpl implements CinemaRoomDao {

    @Override
    public void createCinemaRoom(CinemaRoom cinemaRoom) {
        try(Session session = XmlConnectionConfig.getSession()) {
            session.beginTransaction();
            session.persist(cinemaRoom);
            session.getTransaction().commit();
        }
    }

    @Override
    public Optional<CinemaRoom> getCinemaRoomById(Integer cinemaRoomID) {
        try(Session session = XmlConnectionConfig.getSession()) {
            CinemaRoom cinemaRoom = session.find(CinemaRoom.class, cinemaRoomID);
            return Optional.ofNullable(cinemaRoom);
        }
    }

    @Override
    public List<CinemaRoom> getAllCinemaRoom() {
        try(Session session = XmlConnectionConfig.getSession()) {
            return session.createQuery("SELECT c FROM CinemaRoom c", CinemaRoom.class).getResultList();
        }
    }

    @Override
    public Optional<CinemaRoom> updateCinemaRoomById(CinemaRoom cinemaRoom) {
        try (Session session = XmlConnectionConfig.getSession()) {
            session.beginTransaction();
            CinemaRoom cinemaRoom2 = session.find(CinemaRoom.class, cinemaRoom.getCinemaRoomID());
            if (cinemaRoom2 == null){
                return null;
            }else {
                cinemaRoom2.setCinemaRoomName(cinemaRoom.getCinemaRoomName());
                session.merge(cinemaRoom2);
                session.getTransaction().commit();
                return Optional.of(cinemaRoom);
            }
        }
    }

    @Override
    public Optional<CinemaRoom> deleteCinemaRoomById(Integer cinemaRoomID) {
        try(Session session = XmlConnectionConfig.getSession()) {
            session.beginTransaction();
            CinemaRoom cinemaRoom = session.find(CinemaRoom.class, cinemaRoomID);
            if (cinemaRoom == null) {
                return null;
            }else {
                session.remove(cinemaRoom);
                session.getTransaction().commit();
                return Optional.of(cinemaRoom);
            }
        }
    }
}
