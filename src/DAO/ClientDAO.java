package DAO;

import Model.Client;

import java.util.List;

public interface ClientDAO {
    void insert(Client client);
    void update(Client client);
    void delete(String CPF);
    Client getClient(String CPF);
    List<Client> getAllClients();
}
