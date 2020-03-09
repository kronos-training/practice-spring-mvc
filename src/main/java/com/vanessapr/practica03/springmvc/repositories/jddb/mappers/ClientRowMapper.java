package com.vanessapr.practica03.springmvc.repositories.jddb.mappers;

import com.vanessapr.practica03.springmvc.beans.Client;
import com.vanessapr.practica03.springmvc.repositories.jddb.extractors.ClientExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientRowMapper implements RowMapper<Client> {

    @Override
    public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ClientExtractor().extractData(rs);
    }
}
