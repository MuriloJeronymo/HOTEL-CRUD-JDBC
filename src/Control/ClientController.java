package Control;

import DAO.ClientDAO;
import DAO.DaoFactory;
import Model.Client;

import java.time.LocalDate;
import java.util.List;

public class ClientController {
    private ClientDAO clientDAO = DaoFactory.createClientDAO();

    public Client addClient(String cpf, String name, LocalDate birthDate, String email ){
        Client client = new Client(cpf, name, birthDate, email);
        clientDAO.insert(client);
        return client;
    }
    public void editClient(String cpf, String name, LocalDate birthDate, String email){
        Client client = clientDAO.getClient(cpf);
        clientDAO.update(client);
    }
    public void deleteClient(String cpf){
        Client client = clientDAO.getClient(cpf);
        clientDAO.delete(cpf);
    }
    public void getAllClients(){
        clientDAO.getAllClients();
    }


}
