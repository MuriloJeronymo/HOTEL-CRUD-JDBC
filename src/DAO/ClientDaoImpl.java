package DAO;

import Model.Client;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class ClientDaoImpl implements ClientDAO {
    private Connection conn;

    public ClientDaoImpl(Connection conn) {
        this.conn = conn;
    }
    @Override
    public void insert(Client client) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement("insert into Client values(?,?,?,?)");
            st.setString(1,client.getCPF());
            st.setString(2,client.getName());
            java.sql.Date sqlDate = java.sql.Date.valueOf(client.getBirthDate());
            st.setDate(3,sqlDate);
            st.setString(4,client.getEmail());
            st.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


@Override
public void update(Client client) {
    PreparedStatement st = null;
    try{
        st = conn.prepareStatement("update Client set name=?,birth_date=?,email=? where cpf=? ");
        st.setString(1,client.getName());
        java.sql.Date sqlDate = java.sql.Date.valueOf(client.getBirthDate());
        st.setDate(2,sqlDate);
        st.setString(3,client.getEmail());
        st.executeUpdate();
    }
    catch(Exception e){
        e.printStackTrace();
    }
}

    @Override
    public void delete(Client client) {

    }

    @Override
    public Client getClient(int id) {
        return null;
    }
}


