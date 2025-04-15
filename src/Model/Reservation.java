package Model;

import java.time.Period;
import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reservation {
    private Room room;
    private LocalDate startDay;
    private LocalDate endDay;

    List<Client> clients = new ArrayList<Client>();

    public Reservation(Room room, LocalDate startDay, LocalDate endDay) {
        this.room = room;
        this.startDay = startDay;
        this.endDay = endDay;
    }
    public Room getRoom() {
        return room;
    }
    public void setRoom(Room room) {
        this.room = room;
    }
    public LocalDate getStartDay() {
        return startDay;
    }
    public void setStartDay(LocalDate startDay) {
        this.startDay = startDay;
    }
    public LocalDate getEndDay() {
        return endDay;
    }
    public void setEndDay(LocalDate endDay) {
        this.endDay = endDay;
    }
    public List<Client> getClients() {
        return clients;
    }

    public void addClient(Client client) {
        clients.add(client);
    }
    public void removeClient(Client client) {
        clients.remove(client);
    }

    public Double totalValue(){
        Period timeInReservation = Period.between( startDay,endDay);
        return timeInReservation.getDays() * room.getPricePerDay();

    }

    @Override
    public String toString() {
        return "Reservation{" +
                "room=" + room +
                ", startDay=" + startDay +
                ", endDay=" + endDay +
                ", clients=" + clients +
                '}';
    }
}
