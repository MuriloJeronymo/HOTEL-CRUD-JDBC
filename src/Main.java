import DAO.DB;

import java.sql.Connection;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
         Connection conn = null;
         try{
             conn = DB.getConnection();
         }
         catch(Exception e){
             System.out.println(e);
         }
    }
}