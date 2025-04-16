package DAO;

import Model.Reservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReservationDaoImpl implements ReservationDAO{

    private Connection conn;

    public ReservationDaoImpl(Connection conn) {
        this.conn = conn;
    }
    @Override
    public void inser(Reservation reservation) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement("insert into reservation values(?,?,?,?,?)");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Reservation reservation) {

    }

    @Override
    public void delete(Reservation reservation) {

    }

    @Override
    public Reservation findByCpf(String cpf) {
       PreparedStatement st = null;
       ResultSet rs = null;
       try{
           st = conn.prepareStatement("select * from reservation where cpf = ?");
           st.setString(1, cpf);
           rs = st.executeQuery();
       }
       catch(Exception e){
           e.printStackTrace();
       }
        return null;
    }
}
