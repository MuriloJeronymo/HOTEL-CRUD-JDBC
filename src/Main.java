import DAO.DB;
import Model.Client;
import Model.Reservation;
import Model.Room;

import java.time.LocalDate;
import java.sql.Connection;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("enter room infos");
        int number = sc.nextInt();
        Double price = sc.nextDouble();
        Room room = new Room(number, price);

        System.out.println("enter the days");
        LocalDate startDay = LocalDate.parse(sc.next(), dtf);
        LocalDate endDay = LocalDate.parse(sc.next(), dtf);
        Reservation res = new Reservation(room,startDay,endDay);

        System.out.println("How many clients?");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("enter client infos");
            String cpf = sc.next();
            String name = sc.next();
            LocalDate birthDate = LocalDate.parse(sc.next(), dtf);
            Client client = new Client(cpf, name, birthDate);
            res.addClient(client);
        }

        System.out.println("Valor Total");
        System.out.println(res.totalValue());


        System.out.println(res);


    }
}