package DAO;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;

public class DB {
    private static final String URL ="jdbc:mysql://localhost:3306/HotelDataBase";
    private static final String USER = "root";
    private static final String PASSWord = "root1234";
    private static Connection con = null;

    public static Connection getConnection() {
        if (con == null) {
            try {
                con = DriverManager.getConnection(URL, USER, PASSWord);
                System.out.println("Conectado com sucesso!");


            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return con;
    }

    public static void closeConnection() {
        if (con != null) {
            try{
                con.close();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }



    }
}
