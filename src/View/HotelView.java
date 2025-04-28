package View;

import Control.ReservationController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class HotelView {
    public void viewHotel()  {
        Scanner sc = new Scanner(System.in);
        int menuChoice;

        do {
            System.out.println("-------------------------------------------------------");
            System.out.println("| Hotel |");
            System.out.println("-------------------------------------------------------");
            System.out.println("1 - Reservation ");
            System.out.println("2 - Client");
            System.out.println("3 - Room");
            System.out.println("0 - Exit");
            System.out.println("-------------------------------------------------------");

            menuChoice = sc.nextInt();

            switch (menuChoice) {
                case 1:
                    ReservationView resv = new ReservationView();
                    resv.viewReservation();
                    break;

                case 2:
                    ClientView cv = new ClientView();
                    cv.viewClient();
                    break;
                case 3:
                    RoomView roov = new RoomView();
                    roov.viewRoom();
                    break;
            }
        }while (menuChoice !=0);




        /*
        System.out.printlnln("--------------HOTEL--------------");
        System.out.printlnln("CHECK IN: ");
        String cpf = sc.nextLine();
        String name = sc.nextLine();

        System.out.println("Data de nascimento (dd/MM/yyyy): ");
        String birthDateStr = sc.nextLine();
        LocalDate birthDate = LocalDate.parse(birthDateStr, formatter);

        String email = sc.nextLine();
        int roomNumber = sc.nextInt();
        sc.nextLine();

        System.out.println("Data de início (dd/MM/yyyy): ");
        String startDateStr = sc.nextLine();
        LocalDate startDate = LocalDate.parse(startDateStr, formatter);

        System.out.println("Data de término (dd/MM/yyyy): ");
        String endDateStr = sc.nextLine();
        LocalDate endDate = LocalDate.parse(endDateStr, formatter);

        ReservationController reservationController = new ReservationController();
        reservationController.checkIn(cpf, name, birthDate, email, roomNumber, startDate, endDate);*/



    }
}
