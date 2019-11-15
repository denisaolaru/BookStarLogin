package com.bookStar.project.bookstar.dao;

import com.bookStar.project.bookstar.domain.Books;

import java.util.Collection;

public interface BooksDAO extends BaseDAO<Books> {

    Collection<Books> searchByTitle(String query);
}
