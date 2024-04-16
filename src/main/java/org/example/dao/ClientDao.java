package org.example.dao;

import org.example.entities.Client;

import java.util.List;

public interface ClientDao {
    boolean save(Client client);
    Client findById(Long id);
    List<Client> getAllClients ();
    boolean update(Client client);
    boolean delete(Client client);
}
