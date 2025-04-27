package Control;

import DAO.RoomDAO;
import DAO.RoomDaoImpl;
import Model.Client;
import Model.Reservation;
import Model.Room;
import DAO.DB;

import java.time.LocalDate;

public class ReservationController {
    private RoomDAO roomDAO = new RoomDaoImpl(DB.getConnection());

    public void checkIn(String cpf, String name, LocalDate birthDate, String email, int roomNumber, LocalDate startDate, LocalDate endDate) {
        Client client = new Client(cpf,name,birthDate,email);
        Room room = roomDAO.getRoom(roomNumber);

        Reservation reservation = new Reservation(room,startDate,endDate);




    }
}
