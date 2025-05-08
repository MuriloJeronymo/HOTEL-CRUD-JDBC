package View;

import Control.ClientController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ClientView {
    Scanner sc = new Scanner(System.in);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    ClientController clientController = new ClientController();

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
                    System.out.println("Add Client: ");
                    System.out.println("CPF: ");
                    String cpf = sc.next();
                    System.out.println("Name: ");
                    String name= sc.next();
                    sc.nextLine();
                    System.out.println("Birth Date: ");
                    String birthDateStr = sc.nextLine();
                    LocalDate birthDate = LocalDate.parse(birthDateStr, formatter);
                    System.out.println("Email: ");
                    String email = sc.next();


                    clientController.addClient(cpf,name,birthDate,email);

                    System.out.println("Client Added Successfully");
                    break;
                case 2:
                    System.out.println("Edit Client: ");
                    System.out.println("CPF: ");
                    String newCpf = sc.next();
                    System.out.println("Name: ");
                    String newName= sc.next();
                    sc.nextLine();
                    System.out.println("Birth Date: ");
                    String newBirthDateStr = sc.nextLine();
                    LocalDate newBirthDate = LocalDate.parse(newBirthDateStr, formatter);
                    System.out.println("Email: ");
                    String newEmail = sc.next();
                    clientController.editClient(newCpf,newName,newBirthDate,newEmail);
                    break;
                case 3:
                    System.out.println("Delete Client: ");
                    System.out.println("Enter the CPF to Delete Client: ");
                    String cpfToDelete =sc.next();
                    clientController.deleteClient(cpfToDelete);
                    System.out.println("Client Deleted Successfully");
                    break;
                case 4:
                    System.out.println("All Clients: ");
                    clientController.getAllClients();
                case 0:
                    break;
            }
        }while(clientOpt != 0);
    }
}
