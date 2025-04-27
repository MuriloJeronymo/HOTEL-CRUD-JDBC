package DAO;

import Model.Client;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
    public void delete(String CPF) {
       PreparedStatement st = null;
        try{
            st = conn.prepareStatement("delete from Client where cpf=? ");
            st.setString(1,CPF);
            st.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Client getClient(String CPF) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement("select * from Client where cpf=?");
            st.setString(1,CPF);
            rs = st.executeQuery();

            if(rs.next()){
                String cpf = rs.getString("cpf");
                String name = rs.getString("name");
                java.sql.Date birthDate = rs.getDate("birth_date");
                String email = rs.getString("email");
                Client client = new Client(cpf,name, birthDate.toLocalDate(),email);
                return client;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}


