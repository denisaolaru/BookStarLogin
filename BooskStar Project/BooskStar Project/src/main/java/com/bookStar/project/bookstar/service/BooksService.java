package com.bookStar.project.bookstar.service;


import com.bookStar.project.bookstar.dao.BooksDAO;
import com.bookStar.project.bookstar.dao.db.JDBCBooksDAO;
import com.bookStar.project.bookstar.domain.Books;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;


public class BooksService {
    private static final Logger LOGGER = LoggerFactory.getLogger(BooksService.class);

    @Autowired
    private BooksDAO dao;

    @Autowired
    private JDBCBooksDAO jdbcBooks;


    public Collection<Books> listAll() {
        return dao.getAll();
    }

    public Collection<Books> search(String query) {
        LOGGER.debug("Searching for " + query);
        return dao.searchByTitle(query);
    }

    public boolean delete(Long id) {
        LOGGER.debug("Deleting book for id: " + id);
        Books book = dao.findById(id);
        if (book != null) {
            dao.delete(book);
            return true;
        }
        return false;
    }

    public Books get(Long id) {
        LOGGER.debug("Getting book for id: " + id);
        return dao.findById(id);

    }

    public void save(Books book) throws ValidationException {
        LOGGER.debug("Saving: " + book);
        validate(book);

        dao.update(book);
    }


    private void validate(Books book) throws ValidationException {


        List<String> errors = new LinkedList<String>();

        if (StringUtils.isEmpty(book.getTitle())) {
            errors.add("Title is Empty");
        }

        if (StringUtils.isEmpty(book.getAuthor())) {
            errors.add("Author is Empty");
        }

        if (StringUtils.isEmpty(book.getGenre())) {
            errors.add("Genre is Empty");
        }

        if (StringUtils.isEmpty(book.getLanguage())) {
            errors.add("Language is Empty");
        }


        if (!errors.isEmpty()) {
            throw new ValidationException(Arrays.toString(errors.toArray(new String[]{})));
        }
    }

    public BooksDAO getDao() {
        return dao;
    }

    public void setDao(BooksDAO dao) {
        this.dao = dao;
    }

    public Collection<Books> listAdventure() {
        return jdbcBooks.getAdventure();
    }

    public Collection<Books> listDrama() {
        return jdbcBooks.getDrama();
    }

    public Collection<Books> listFantasy() {
        return jdbcBooks.getFantasy();
    }

    public Collection<Books> listHorror() {
        return jdbcBooks.getHorror();
    }

    public Collection<Books> listMystery() {
        return jdbcBooks.getMystery();
    }

    public Collection<Books> listPoetry() {
        return jdbcBooks.getPoetry();
    }

    public Collection<Books> listRomance() {
        return jdbcBooks.getRomance();
    }

    public Collection<Books> listSF() {
        return jdbcBooks.getSF();
    }
}
