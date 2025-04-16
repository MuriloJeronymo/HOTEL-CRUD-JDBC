package DAO;

import Model.Reservation;

public interface ReservationDAO {
    void inser(Reservation reservation);
    void update(Reservation reservation);
    void delete(Reservation reservation);
    Reservation findByCpf(String cpf);
}
