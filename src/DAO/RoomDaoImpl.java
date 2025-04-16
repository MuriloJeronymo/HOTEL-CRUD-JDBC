package DAO;

import Model.Room;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
}
