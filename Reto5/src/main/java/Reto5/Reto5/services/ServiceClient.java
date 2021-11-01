/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto5.Reto5.services;

import Reto5.Reto5.models.Client;
import Reto5.Reto5.repositories.RepositoryClient;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author WizzardShadow
 */

@Service

public class ServiceClient {
    
    @Autowired
    private RepositoryClient metodosCrud;

    public List<Client> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Client> getClient(int idClient) {
        return metodosCrud.getClient(idClient);
    }

    public Client save(Client client) {
        if (client.getIdClient() == null) {
            return metodosCrud.save(client);
        } else {
            Optional<Client> e = metodosCrud.getClient(client.getIdClient());
            if (e.isEmpty()) {
                return metodosCrud.save(client);
            } else {
                return client;
            }
        }
    }

    public Client update(Client client) {
        if (client.getIdClient() != null) {
            Optional<Client> e = metodosCrud.getClient(client.getIdClient());
            if (!e.isEmpty()) {
                if (client.getName() != null) {
                    e.get().setName(client.getName());
                }
                if (client.getAge() != null) {
                    e.get().setAge(client.getAge());
                }
                if (client.getPassword() != null) {
                    e.get().setPassword(client.getPassword());
                }
                metodosCrud.save(e.get());
                return e.get();
            } else {
                return client;
            }
        } else {
            return client;
        }
    }

    public boolean deleteClient(int idClient) {
        Boolean aBoolean = getClient(idClient).map(client -> {
            metodosCrud.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
}
