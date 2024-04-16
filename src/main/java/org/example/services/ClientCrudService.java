package org.example.services;

import org.example.dao.ClientDao;
import org.example.dao.ClientDaoImpl;
import org.example.entities.Client;

import java.util.List;

public class ClientCrudService {
    private ClientDao clientDao = new ClientDaoImpl();

    public void saveClient(Client client) {
        clientDao.save(client);
    }

    public Client findClientById(Long id) {
        return clientDao.findById(id);
    }

    public List<Client> getAllClients () {return clientDao.getAllClients();}

    public void updateClient(Client client) {
        clientDao.update(client);
    }

    public void deleteClient(Client client) {
        clientDao.delete(client);
    }
}
