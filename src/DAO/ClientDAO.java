package DAO;

import Model.Client;

public interface ClientDAO {
    void insert(Client client);
    void update(Client client);
    void delete(String CPF);
    Client getClient(String CPF);
}
