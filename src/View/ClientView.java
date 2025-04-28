package View;

import java.util.Scanner;

public class ClientView {
    Scanner sc = new Scanner(System.in);
    public void viewClient(){
        int clientOpt;
        do {
            System.out.println("1 - Add Client ");
            System.out.println("2 - Edit Client ");
            System.out.println("3 - Delete Client ");
            System.out.println("4 - Show Clients");
            System.out.println("0 - Back To Main Menu");
            System.out.println("----------------------------------------------------");

            clientOpt = sc.nextInt();

            switch (clientOpt) {
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
                    //show
                case 0:
                    break;
            }
        }while(clientOpt != 0);
    }
}
