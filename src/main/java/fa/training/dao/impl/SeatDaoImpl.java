package fa.training.dao.impl;

import fa.training.dao.SeatDao;
import fa.training.entities.Seat;
import fa.training.utils.XmlConnectionConfig;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class SeatDaoImpl implements SeatDao {
    @Override
    public void createSeat(Seat seat) {
        try (Session session = XmlConnectionConfig.getSession()) {
            session.beginTransaction();
            session.persist(seat);
            session.getTransaction().commit();
        }
    }

    @Override
    public Optional<Seat> getSeatById(Integer seatID) {
        try (Session session = XmlConnectionConfig.getSession()) {
            Seat seat = session.find(Seat.class, seatID);
            return Optional.ofNullable(seat);
        }
    }

    @Override
    public List<Seat> getAllSeat() {
        try(Session session = XmlConnectionConfig.getSession()) {
            return session.createQuery("SELECT s FROM Seat s", Seat.class).getResultList();
        }
    }

    @Override
    public Optional<Seat> updateSeatById(Seat seat) {
        try (Session session = XmlConnectionConfig.getSession()) {
            session.beginTransaction();
            Seat seat2 = session.find(Seat.class, seat.getSeatID());
            if (seat2 == null) {
                return null;
            }else {
                seat2.setSeatColumn(seat.getSeatColumn());
                seat2.setSeatRow(seat.getSeatRow());
                seat2.setSeatStatus(seat.getSeatStatus());
                seat2.setSeatType(seat.getSeatType());

                session.merge(seat2);
                session.getTransaction().commit();
                return Optional.of(seat);
            }
        }
    }

    @Override
    public Optional<Seat> deleteSeatById(Integer seatID) {
        try(Session session = XmlConnectionConfig.getSession()) {
            session.beginTransaction();
            Seat seat = session.find(Seat.class, seatID);
            if (seat == null) {
                return null;
            }else {
                session.remove(seat);
                session.getTransaction().commit();
                return Optional.ofNullable(seat);
            }
        }
    }
}
