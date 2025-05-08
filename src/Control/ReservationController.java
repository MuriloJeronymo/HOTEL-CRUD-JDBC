package Control;

import DAO.*;
import Model.Client;
import Model.Reservation;
import Model.Room;
import Model.RoomStatus;

import java.time.LocalDate;

public class ReservationController {
    private RoomDAO roomDAO = new RoomDaoImpl(DB.getConnection());
    private ClientDAO clientDAO = DaoFactory.createClientDAO();
    private ReservationDAO reservationDAO = DaoFactory.createReservationDAO();


    public void checkIn(String cpf, String name, LocalDate birthDate, String email, int roomNumber, LocalDate startDate, LocalDate endDate) {
        ClientController clientController = new ClientController();
        Client client = clientController.addClient(cpf, name, birthDate, email);

        Room room = roomDAO.getRoom(roomNumber);
        if (room == null) {
            throw new RuntimeException("Quarto não encontrado");
        }

        if (room.getStatus() != RoomStatus.available) {
            throw new RuntimeException("Quarto não está disponível");
        }

        Reservation reservation = new Reservation(room, startDate, endDate);
        reservation.addClient(client);

        room.setStatus(RoomStatus.unavailable);
        roomDAO.updateRoomStatusToUnavailable(roomNumber);



        reservationDAO.insert(reservation);


        System.out.println("Check-in realizado com sucesso!");
        System.out.println("Cliente: " + client.getName());
        System.out.println("Quarto: " + room.getNumber());
        System.out.println("Período: " + startDate + " até " + endDate);
        System.out.println("Valor total: R$" + reservation.totalValue());
    }

    public void findByCpf(String cpf) {
        reservationDAO.findByCpf(cpf);
    }
    public void findByRoomNumber(int roomNumber) {
        reservationDAO.findByRoomNumber(roomNumber);
    }



    }

