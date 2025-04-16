package DAO;

public class DaoFactory {

    public static RoomDAO createRoomDAO() {
        return new RoomDaoImpl(DB.getConnection());
    }

    /*public static ClientDAO createClientDAO() {
        return new ClientDaoImpl(DB.getConnection());
    }*/

    public static ReservationDAO createReservationDAO() {
        return new ReservationDaoImpl(DB.getConnection());
    }
}
