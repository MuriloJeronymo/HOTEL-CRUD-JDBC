package View;

import java.util.Scanner;

public class ReservationView {
    Scanner sc = new Scanner(System.in);

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
                    //check in
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
