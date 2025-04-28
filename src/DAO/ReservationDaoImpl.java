package DAO;

import Model.Client;
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
    public void insert(Reservation reservation) {
        PreparedStatement st = null;
        try {
            // Primeiro, inserimos na tabela reservation
            st = conn.prepareStatement("INSERT INTO reservation (roomNumber, startDate, endDate, totalValue) VALUES (?, ?, ?, ?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            st.setInt(1, reservation.getRoom().getNumber());
            st.setDate(2, java.sql.Date.valueOf(reservation.getStartDay()));
            st.setDate(3, java.sql.Date.valueOf(reservation.getEndDay()));
            st.setDouble(4, reservation.totalValue());
            st.executeUpdate();

            // Obter o ID da reserva gerado
            ResultSet rs = st.getGeneratedKeys();
            int reservationId = 0;
            if (rs.next()) {
                reservationId = rs.getInt(1);
            }

            // Agora, inserimos na tabela de relacionamento reservation_client para cada cliente
            for (Client client : reservation.getClients()) {
                PreparedStatement st2 = conn.prepareStatement("INSERT INTO reservationclient (reservationId, cpf) VALUES (?, ?)");
                st2.setInt(1, reservationId);
                st2.setString(2, client.getCPF());
                st2.executeUpdate();
                st2.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
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
           st = conn.prepareStatement("select * from reservationclient where cpf = ?");
           st.setString(1, cpf);
           rs = st.executeQuery();

           if (rs.next()) {

           }
       }
       catch(Exception e){
           e.printStackTrace();
       }
        return null;
    }

    @Override
    public Reservation findByRoomNumber(int roomNumber) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement("select * from reservation where roomNumber = ?");
            st.setInt(1, roomNumber);
            rs = st.executeQuery();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
