package DAO;

import Model.Client;

public interface ClientDAO {
    void insert(Client client);
    void update(Client client);
    void delete(Client client);
    Client getClient(int id);
}
