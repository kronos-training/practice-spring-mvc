package com.vanessapr.practica03.springmvc.services.impl;

import com.vanessapr.practica03.springmvc.beans.Client;
import com.vanessapr.practica03.springmvc.repositories.ClientRepository;
import com.vanessapr.practica03.springmvc.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    @Qualifier("memory")
    private ClientRepository repository;

    @Override
    public void save(Client client) {
        repository.save(client);
    }

    @Override
    public void update(Client client) {
        repository.update(client);
    }

    @Override
    public void remove(int id) {
        repository.remove(id);
    }

    @Override
    public Client find(int id) {
        return repository.find(id);
    }

    @Override
    public List<Client> findAll() {
        return repository.findAll();
    }
}
