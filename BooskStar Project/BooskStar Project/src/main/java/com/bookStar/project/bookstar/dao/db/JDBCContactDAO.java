package com.bookStar.project.bookstar.dao.db;

import com.bookStar.project.bookstar.dao.ContactDAO;
import com.bookStar.project.bookstar.domain.Contact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class JDBCContactDAO implements ContactDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(JDBCBooksDAO.class);

    private String host;
    private String port;
    private String dbName;
    private String userName;
    private String pass;

    public JDBCContactDAO(String host, String port, String dbName, String userName, String pass) {
        this.host = host;
        this.userName = userName;
        this.pass = pass;
        this.port = port;
        this.dbName = dbName;
    }

    protected Connection newConnection() {
        try {
            Class.forName("org.postgresql.Driver").newInstance();

            String url = new StringBuilder()
                    .append("jdbc:")
                    .append("postgresql")
                    .append("://")
                    .append(host)
                    .append(":")
                    .append(port)
                    .append("/")
                    .append(dbName)
                    .append("?user=")
                    .append(userName)
                    .append("&password=")
                    .append(pass).toString();
            Connection result = DriverManager.getConnection(url);
            result.setAutoCommit(false);

            return result;
        } catch (Exception ex) {
            throw new RuntimeException("Error getting DB connection", ex);
        }

    }


    @Override
    public Collection<Contact> getAll() {
        Collection<Contact> result = new LinkedList<>();

        try (Connection connection = newConnection();
             ResultSet rs = connection.createStatement()
                     .executeQuery("select * from contact")) {

            while (rs.next()) {
                result.add(extractContact(rs));
            }
            connection.commit();
        } catch (SQLException ex) {

            throw new RuntimeException("Error getting contact.", ex);
        }

        return result;
    }

    @Override
    public Contact findById(Long id) {
        Connection connection = newConnection();

        List<Contact> result = new LinkedList<>();

        try (ResultSet rs = connection.createStatement()
                .executeQuery("select * from contact where id = " + id)) {

            while (rs.next()) {
                result.add(extractContact(rs));
            }
            connection.commit();
        } catch (SQLException ex) {

            throw new RuntimeException("Error getting contact.", ex);
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {

            }
        }

        if (result.size() > 1) {
            throw new IllegalStateException("Multiple contact for id: " + id);
        }
        return result.isEmpty() ? null : result.get(0);
    }

    @Override
    public Contact update(Contact model) {

        Connection connection = newConnection();
        try {
            PreparedStatement ps = null;
            if (model.getId() > 0) {
                ps = connection.prepareStatement(
                        "update contact set name=?, email=?, subject=?, message=?"
                                + "where id = ? returning id");

            } else {
                ps = connection.prepareStatement(
                        "insert into contact (name, email, subject, message) "
                                + "values (?, ?, ?, ?) returning id");

            }
            ps.setString(1, model.getName());
            ps.setString(2, model.getEmail());
            ps.setString(3, model.getSubject());
            ps.setString(4, model.getMessage());


            if (model.getId() > 0) {
                ps.setLong(5, model.getId());
            }

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                model.setId(rs.getLong(1));
            }
            rs.close();

            connection.commit();

        } catch (SQLException ex) {

            throw new RuntimeException("Error getting contact.", ex);
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {

            }
        }

        return model;
    }


    @Override
    public boolean delete(Contact model) {
        boolean result = false;
        Connection connection = newConnection();
        try {
            Statement statement = connection.createStatement();
            result = statement.execute("delete from contact where id = " + model.getId());
            connection.commit();
        } catch (SQLException ex) {

            throw new RuntimeException("Error updating contact.", ex);
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {

            }
        }
        return result;
    }


    public Contact extractContact (ResultSet rs  ) throws SQLException {
        Contact contact = new Contact ();
        contact.setId ( rs.getLong ( "id" ) );
        contact.setName ( rs.getString ( "name" ) );
        contact.setEmail ( rs.getString ( "email" ) );
        contact.setSubject ( rs.getString ( "subject" ) );
        contact.setMessage ( rs.getString ( "message" ) );

        return contact;
    }
}

