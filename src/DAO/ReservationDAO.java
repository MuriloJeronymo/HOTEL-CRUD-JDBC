package DAO;

import Model.Reservation;

public interface ReservationDAO {
    void insert(Reservation reservation);
    void update(Reservation reservation);
    void delete(Reservation reservation);
    Reservation findByCpf(String cpf);
    Reservation findByRoomNumber(int roomNumber);

}
