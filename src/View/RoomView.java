package View;

import Control.RoomController;

import java.util.Scanner;

public class RoomView {
    Scanner sc = new Scanner(System.in);
    public void viewRoom(){
        RoomController roomController = new RoomController();

        int roomOpt;
        do {

            System.out.println("1 - Edit Room Price ");
            System.out.println("2 - Show Available Rooms");
            System.out.println("3 - Show Unavailable Rooms");
            System.out.println("4 - Interdict");
            System.out.println("0 - Back To Main Menu");
            System.out.println("----------------------------------------------------");

            roomOpt = sc.nextInt();

            switch (roomOpt) {
                case 1:
                    System.out.print("Enter Room Number to edit price: ");
                    int number = sc.nextInt();
                    System.out.print("Enter new price: ");
                    double newPrice = sc.nextDouble();
                    roomController.editRoomPrice(number, newPrice);
                    break;
                case 2:
                    System.out.println("AVAILABLE ROOMS: ");
                    roomController.showAvailableRooms();

                    break;
                case 3:
                    System.out.println("UNAVAILABLE ROOMS: ");
                    roomController.showUnavailableRooms();
                    break;
                case 4:
                    System.out.print("Enter Room Number to interdict ");
                    int numberToInterdict = sc.nextInt();
                    roomController.interdict(numberToInterdict);
                case 0:
                    break;
            }

        }while(roomOpt != 0);



    }
}
