package View;

import Control.ReservationController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ReservationView {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    Scanner sc = new Scanner(System.in);
    ReservationController reservationController = new ReservationController();

    public void viewReservation() {
        int reservOpt;
        do {
            System.out.println("1 - Check-In ");
            System.out.println("2 - Check-Out ");
            System.out.println("3 - Show Reservations ");
            System.out.println("0 - Back To Main Menu");
            System.out.println("----------------------------------------------------");
            reservOpt = sc.nextInt();

            switch (reservOpt) {
                case 1:
                    System.out.println("Add Client: ");
                    System.out.println("CPF: ");
                    String cpf = sc.next();
                    System.out.println("Name: ");
                    String name= sc.next();
                    sc.nextLine();
                    System.out.println("Birth Date: ");
                    LocalDate birthDate = LocalDate.parse(sc.nextLine(), formatter);
                    System.out.println("Email: ");
                    String email = sc.next();
                    sc.nextLine();
                    System.out.println("Room Number: ");
                    int roomNumber = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Start Day: ");
                    LocalDate startDate = LocalDate.parse( sc.nextLine(), formatter);
                    System.out.println("End Day: ");
                    LocalDate endDate = LocalDate.parse( sc.nextLine(), formatter);
                    reservationController.checkIn(cpf, name, birthDate, email, roomNumber, startDate, endDate);


                    break;
                case 2:
                    // check out
                    break;
                case 3:
                    // show
                    break;
                case 0:
                    break;
            }

        }while(reservOpt != 0);
    }
}
