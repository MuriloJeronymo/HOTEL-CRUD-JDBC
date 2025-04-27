package DAO;

import Model.Room;

import java.util.List;

public interface RoomDAO {
    void insertRoom(Room room);
    void updateRoom(Room room);
    void updateRoomStatusToAvailable(int number);
    void updateRoomStatusToUnavailable(int number);
    void deleteRoom(int number);
    List<Room> getAvailableRooms();
    List<Room> getUnavailableRooms();
    Room getRoom(int number);


}
