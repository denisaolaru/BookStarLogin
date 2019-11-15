package com.bookStar.project.bookstar.dao.db;

import com.bookStar.project.bookstar.dao.BooksDAO;
import com.bookStar.project.bookstar.domain.Books;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class JDBCBooksDAO implements BooksDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(JDBCBooksDAO.class);

    private String host;
    private String port;
    private String dbName;
    private String userName;
    private String pass;

    public JDBCBooksDAO(String host, String port, String dbName, String userName, String pass) {
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
    public Collection<Books> searchByTitle(String query) {
        if (query == null) {
            query = "";
        } else {
            query = query.trim();
        }

        Connection connection = newConnection();

        Collection<Books> result = new LinkedList<>();

        try (ResultSet rs = connection.createStatement()
                .executeQuery("select * from books "
                        + "where lower(title) like '%"
                        + query.toLowerCase() + "%'")) {

            while (rs.next()) {
                result.add(extractBooks(rs));
            }
            connection.commit();
        } catch (SQLException ex) {

            throw new RuntimeException("Error getting books.", ex);
        }

        return result;
    }

    @Override
    public Collection<Books> getAll() {
        Collection<Books> result = new LinkedList<>();

        try (Connection connection = newConnection();
             ResultSet rs = connection.createStatement()
                     .executeQuery("select * from books")) {

            while (rs.next()) {
                result.add(extractBooks(rs));
            }
            connection.commit();
        } catch (SQLException ex) {

            throw new RuntimeException("Error getting books.", ex);
        }

        return result;
    }

    @Override
    public Books findById(Long id) {
        Connection connection = newConnection();

        List<Books> result = new LinkedList<>();

        try (ResultSet rs = connection.createStatement()
                .executeQuery("select * from books where id = " + id)) {

            while (rs.next()) {
                result.add(extractBooks(rs));
            }
            connection.commit();
        } catch (SQLException ex) {

            throw new RuntimeException("Error getting books.", ex);
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {

            }
        }

        if (result.size() > 1) {
            throw new IllegalStateException("Multiple books for id: " + id);
        }
        return result.isEmpty() ? null : result.get(0);
    }

    @Override
    public Books update(Books model) {
        Connection connection = newConnection();
        try {
            PreparedStatement ps = null;
            if (model.getId() > 0) {
                ps = connection.prepareStatement(
                        "update books set title=?, author=?, genre=?, language=?, year=?, price=?, photopath=?, single=?"
                                + "where id = ? returning id");

            } else {
                ps = connection.prepareStatement(
                        "insert into books (title, author, genre, language, year, price, photopath, single) "
                                + "values (?, ?, ?, ?, ?, ?, ?, ?) returning id");

            }
            ps.setString(1, model.getTitle());
            ps.setString(2, model.getAuthor());
            ps.setString(3, model.getGenre());
            ps.setString(4, model.getLanguage());
            ps.setInt(5, model.getYear());
            ps.setDouble(6, model.getPrice());
            ps.setString(7, model.getPhotopath());
            ps.setString(8, model.getSinglePath());
            if (model.getId() > 0) {
                ps.setLong(9, model.getId());
            }

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                model.setId(rs.getLong(1));
            }
            rs.close();

            connection.commit();

        } catch (SQLException ex) {

            throw new RuntimeException("Error getting books.", ex);
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {

            }
        }

        return model;
    }

    @Override
    public boolean delete(Books model) {
        boolean result = false;
        Connection connection = newConnection();
        try {
            Statement statement = connection.createStatement();
            result = statement.execute("delete from books where id = " + model.getId());
            connection.commit();
        } catch (SQLException ex) {

            throw new RuntimeException("Error updating books.", ex);
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {

            }
        }
        return result;

    }


    private Books extractBooks(ResultSet rs) throws SQLException {
        Books books = new Books();
        books.setId(rs.getLong("id"));
        books.setTitle(rs.getString("title"));
        books.setAuthor(rs.getString("author"));
        books.setGenre(rs.getString("genre"));
        books.setLanguage(rs.getString("language"));
        books.setYear(rs.getInt("year"));
        books.setPrice(rs.getDouble("price"));
        books.setPhotopath(rs.getString("photopath"));
        books.setSinglePath(rs.getString("single"));
        return books;

    }

    public Collection<Books> getAdventure() {
        Collection<Books> model = new LinkedList<>();

        try (Connection connection = newConnection();
             ResultSet rs = connection.createStatement()
                     .executeQuery("SELECT * FROM books WHERE genre = 'Adventure'")) {

            while (rs.next()) {
                model.add(extractBooks(rs));
            }
            connection.commit();
        } catch (SQLException ex) {

            throw new RuntimeException("Error getting books.", ex);
        }

        return model;
    }

    public Collection<Books> getDrama() {
        Collection<Books> model = new LinkedList<>();

        try (Connection connection = newConnection();
             ResultSet rs = connection.createStatement()
                     .executeQuery("SELECT * FROM books WHERE genre = 'Drama'")) {

            while (rs.next()) {
                model.add(extractBooks(rs));
            }
            connection.commit();
        } catch (SQLException ex) {

            throw new RuntimeException("Error getting books.", ex);
        }

        return model;

    }

    public Collection<Books> getFantasy() {
        Collection<Books> model = new LinkedList<>();

        try (Connection connection = newConnection();
             ResultSet rs = connection.createStatement()
                     .executeQuery("SELECT * FROM books WHERE genre = 'Fantasy'")) {

            while (rs.next()) {
                model.add(extractBooks(rs));
            }
            connection.commit();
        } catch (SQLException ex) {

            throw new RuntimeException("Error getting books.", ex);
        }

        return model;

    }

    public Collection<Books> getHorror() {
        Collection<Books> model = new LinkedList<>();

        try (Connection connection = newConnection();
             ResultSet rs = connection.createStatement()
                     .executeQuery("SELECT * FROM books WHERE genre = 'Horror'")) {

            while (rs.next()) {
                model.add(extractBooks(rs));
            }
            connection.commit();
        } catch (SQLException ex) {

            throw new RuntimeException("Error getting books.", ex);
        }

        return model;

    }

    public Collection<Books> getMystery() {
        Collection<Books> model = new LinkedList<>();

        try (Connection connection = newConnection();
             ResultSet rs = connection.createStatement()
                     .executeQuery("SELECT * FROM books WHERE genre = 'Mystery'")) {

            while (rs.next()) {
                model.add(extractBooks(rs));
            }
            connection.commit();
        } catch (SQLException ex) {

            throw new RuntimeException("Error getting books.", ex);
        }

        return model;

    }

    public Collection<Books> getPoetry() {
        Collection<Books> model = new LinkedList<>();

        try (Connection connection = newConnection();
             ResultSet rs = connection.createStatement()
                     .executeQuery("SELECT * FROM books WHERE genre = 'Poetry'")) {

            while (rs.next()) {
                model.add(extractBooks(rs));
            }
            connection.commit();
        } catch (SQLException ex) {

            throw new RuntimeException("Error getting books.", ex);
        }

        return model;

    }

    public Collection<Books> getRomance() {
        Collection<Books> model = new LinkedList<>();

        try (Connection connection = newConnection();
             ResultSet rs = connection.createStatement()
                     .executeQuery("SELECT * FROM books WHERE genre = 'Romance'")) {

            while (rs.next()) {
                model.add(extractBooks(rs));
            }
            connection.commit();
        } catch (SQLException ex) {

            throw new RuntimeException("Error getting books.", ex);
        }

        return model;

    }

    public Collection<Books> getSF() {
        Collection<Books> model = new LinkedList<>();

        try (Connection connection = newConnection();
             ResultSet rs = connection.createStatement()
                     .executeQuery("SELECT * FROM books WHERE genre = 'SF'")) {

            while (rs.next()) {
                model.add(extractBooks(rs));
            }
            connection.commit();
        } catch (SQLException ex) {

            throw new RuntimeException("Error getting books.", ex);
        }

        return model;

    }
}
