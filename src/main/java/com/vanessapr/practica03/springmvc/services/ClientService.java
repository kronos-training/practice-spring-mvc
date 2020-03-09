package com.vanessapr.practica03.springmvc.services;

import com.vanessapr.practica03.springmvc.beans.Client;

import java.util.List;

public interface ClientService {

    void save(Client client);
    void update(Client client);
    void remove(int id);
    Client find(int id);
    List<Client> findAll();
}
