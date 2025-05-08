package Control;

import DAO.RoomDAO;
import DAO.DaoFactory;

public class RoomController {
     private RoomDAO roomDao = DaoFactory.createRoomDAO();

     public void showAvailableRooms(){
         roomDao.getAvailableRooms();
     }
     public void showUnavailableRooms(){
         roomDao.getUnavailableRooms();
     }
     public void interdict (int number){
         roomDao.updateRoomStatusToUnavailable(number);
     }
     public void editRoomPrice (int number, double newPrice){
         roomDao.updateRoomPrice(number, newPrice);
     }
}
