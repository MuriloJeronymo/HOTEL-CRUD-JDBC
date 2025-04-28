package View;

import java.util.Scanner;

public class RoomView {
    Scanner sc = new Scanner(System.in);
    public void viewRoom(){
        int roomOpt;
        do {
            System.out.println("1 - Add Room ");
            System.out.println("2 - Edit Room ");
            System.out.println("3 - Delete Room ");
            System.out.println("4 - Show Available Rooms");
            System.out.println("5 - Show Unavailable Rooms");
            System.out.println("6 - Interdict");
            System.out.println("0 - Back To Main Menu");
            System.out.println("----------------------------------------------------");

            roomOpt = sc.nextInt();

            switch (roomOpt) {
                case 1:
                    //add
                    break;
                case 2:
                    // edit
                    break;
                case 3:
                    // delete
                    break;
                case 4:
                    //show avaa
                case 5:
                    //show una
                case 6:
                    // interdict
                case 0:
                    break;
            }

        }while(roomOpt != 0);



    }
}
