package View;

import java.time.LocalDate;
import java.util.Scanner;

public class HotelView {
    public void viewHotel() {
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------HOTEL--------------");
        System.out.println("CHECK IN: ");
        String cpf = sc.nextLine();
        String name  = sc.nextLine();
        LocalDate birthDate = LocalDate.parse(sc.nextLine());
        String email = sc.nextLine();
        int roomNumber = sc.nextInt();
        LocalDate startDate = LocalDate.parse(sc.nextLine());
        LocalDate endDate = LocalDate.parse(sc.nextLine());


    }
}
