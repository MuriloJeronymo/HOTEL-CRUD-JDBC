package DAO;

import Model.Client;
import Model.Room;
import Model.RoomStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoomDaoImpl implements RoomDAO{
    private Connection conn;

    public RoomDaoImpl(Connection conn){
        this.conn = conn;
    }



    @Override
    public void insertRoom(Room room) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement("insert into Room values(?,?,?)");
            st.setInt(1,room.getNumber());
            st.setDouble(2,room.getPricePerDay());
            st.setString(3, room.getStatus().name());
            st.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateRoomPrice(int number, double newPrice) {
        PreparedStatement st = null;
        try {
            Room existingRoom = getRoom(number);
            if (existingRoom == null) {
                System.out.println("Room " + number + " not found!");
                return;
            }

            st = conn.prepareStatement("update room set pricePerDay=? where roomNumber=?");
            st.setDouble(1, newPrice);
            st.setInt(2, number);
            st.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateRoom(Room room) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement("update Room set number=?,pricePerDay=?,status=? ");
            st.setInt(1,room.getNumber());
            st.setDouble(2,room.getPricePerDay());
            st.setString(3,room.getStatus().name());
            st.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateRoomStatusToAvailable(int number) {
          PreparedStatement st = null;
          try{
              st = conn.prepareStatement("update Room set status=? where number=?");
              st.setString(1, String.valueOf(RoomStatus.available));
              st.setInt(2, number);
              st.executeUpdate();
          }
          catch(Exception e){
              e.printStackTrace();
          }
    }

    public void updateRoomStatusToUnavailable(int number) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement("update room set STATUS=? where roomNumber=?");
            st.setString(1, String.valueOf(RoomStatus.unavailable));
            st.setInt(2, number);
            st.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRoom(int number) {    //NAO SEI SE FAZ SENTIDO DELETAR UM ROOM, MAS CRIADO O METODO CASO NECESSARIO
         PreparedStatement st = null;
         try{
             st = conn.prepareStatement("DELETE FROM room WHERE roomNumber=?");
             st.setInt(1,number);
             st.executeUpdate();
         }
         catch(Exception e){
             e.printStackTrace();
         }
    }

    @Override
    public List<Room> getAvailableRooms() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement("select * from room where STATUS = 'available'");
            rs = st.executeQuery();

            List<Room> availableRooms = new ArrayList<Room>();

            while(rs.next()){
                int number = rs.getInt("roomNumber");
                double pricePerDay = rs.getDouble("pricePerDay");
                RoomStatus status = RoomStatus.valueOf(rs.getString("STATUS"));
                Room room = new Room(number,pricePerDay,status);

                availableRooms.add(room);

            }
            for (Room roomsA : availableRooms) {
                System.out.println(roomsA);
            }
            return availableRooms;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Room> getUnavailableRooms() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement("select * from room where STATUS = 'unavailable'");
            rs = st.executeQuery();

            List<Room> unavailableRooms = new ArrayList<Room>();

            while(rs.next()){
                int number = rs.getInt("roomNumber");
                double pricePerDay = rs.getDouble("pricePerDay");
                RoomStatus status = RoomStatus.valueOf(rs.getString("STATUS"));
                Room room = new Room(number,pricePerDay,status);

                unavailableRooms.add(room);

                }
            for(Room roomsU : unavailableRooms){
                System.out.println(roomsU);
            }
            return unavailableRooms;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Room getRoom(int number) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement("select * from room where roomNumber=?");
            st.setInt(1,number);
            rs = st.executeQuery();

            if(rs.next()){
                Integer roomNumber = rs.getInt("roomNumber");
                Double pricePerDay = rs.getDouble("pricePerDay");
                RoomStatus status = RoomStatus.valueOf(rs.getString("status"));
                Room room = new Room(roomNumber,pricePerDay,status);
                return room;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
