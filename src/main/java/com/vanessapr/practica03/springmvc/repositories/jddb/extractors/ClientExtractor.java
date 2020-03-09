package com.vanessapr.practica03.springmvc.repositories.jddb.extractors;

import com.vanessapr.practica03.springmvc.beans.Client;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientExtractor implements ResultSetExtractor<Client> {

    @Override
    public Client extractData(ResultSet rs) throws SQLException, DataAccessException {

        if (rs.isBeforeFirst()) {
            rs.next();
        }

        return new Client(rs.getInt("id"),
                rs.getString("nombres"),
                rs.getString("apellidos"),
                rs.getString("correo"),
                rs.getString("telefono"));
    }
}
