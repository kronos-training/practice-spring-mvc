package com.vanessapr.practica03.springmvc.repositories.jddb.impl;

import com.vanessapr.practica03.springmvc.beans.Client;
import com.vanessapr.practica03.springmvc.repositories.ClientRepository;
import com.vanessapr.practica03.springmvc.repositories.jddb.extractors.ClientExtractor;
import com.vanessapr.practica03.springmvc.repositories.jddb.mappers.ClientRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Qualifier("jdbcTemplate")
public class ClientRepositoryImpl implements ClientRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void save(Client client) {
        jdbcTemplate.update("INSERT INTO clientes (nombres, apellidos, correo, telefono) VALUES (?, ?, ?, ?)",
                client.getName(), client.getLastName(), client.getEmail(), client.getNumberPhone());

    }

    @Override
    public void update(Client client) {
        jdbcTemplate.update("UPDATE clientes SET nombres =?, apellidos=?, correo=?, telefono=? WHERE id=?",
                client.getName(), client.getLastName(), client.getEmail(), client.getNumberPhone(), client.getId());
    }

    @Override
    public void remove(int id) {
        jdbcTemplate.update("DELETE FROM clientes WHERE id=?", id);
    }

    @Override
    public Client find(int id) {
        try {
            return jdbcTemplate.query(
                    "SELECT id, nombres, apellidos, correo, telefono FROM clientes WHERE id=?",
                    new ClientExtractor(),
                    id);
        } catch (Exception e) {
            return null;
        }
    }

    public List<Client> findAll() {
        return jdbcTemplate.query("SELECT id, nombres, apellidos, correo, telefono FROM clientes", new ClientRowMapper());
    }

}
