package com.vanessapr.practica03.springmvc.repositories.memory;

import com.vanessapr.practica03.springmvc.beans.Client;
import com.vanessapr.practica03.springmvc.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Qualifier("memory")
public class ClientMemoryImpl implements ClientRepository {
    private List<Client> clients = new ArrayList<>();

    public ClientMemoryImpl() {
        clients.add(new Client(1, "Vanessa", "Paco", "vanessa@mail.com", "45089856"));
        clients.add(new Client(2, "Mary", "Flores", "mflores@mail.com", "45089856"));
        clients.add(new Client(3, "Julio", "Mendoza", "jmendoza@mail.com", "45089856"));
        clients.add(new Client(4, "Ernesto", "Perca", "eperca@mail.com", "45089856"));
    }

    @Override
    public void save(Client client) {
        clients.add(client);
    }

    @Override
    public void update(Client client) {
        Client clientFound = find(client.getId());

        if (clientFound != null) {
            clientFound.setEmail(client.getEmail());
            clientFound.setName(client.getName());
            clientFound.setLastName(client.getLastName());
            clientFound.setNumberPhone(client.getNumberPhone());
        }
    }

    @Override
    public void remove(int id) {
        Client client = find(id);
        if (client != null) {
            clients.remove(client);
        }
    }

    @Override
    public Client find(int id) {
        return clients.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Client> findAll() {
        return clients;
    }
}
