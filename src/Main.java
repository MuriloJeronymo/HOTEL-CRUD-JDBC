import DAO.DB;
import DAO.DaoFactory;
import DAO.RoomDAO;
import Model.Client;
import Model.Reservation;
import Model.Room;
import Model.RoomStatus;

import java.time.LocalDate;
import java.sql.Connection;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ParseException {
      RoomDAO roomDAO = DaoFactory.createRoomDAO();
      Room room = new Room(10,200.0, RoomStatus.available);
      roomDAO.insertRoom(room);


    }
}