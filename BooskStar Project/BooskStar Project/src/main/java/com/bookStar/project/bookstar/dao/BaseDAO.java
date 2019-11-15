package com.bookStar.project.bookstar.dao;

import com.bookStar.project.bookstar.domain.AbstractModel;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface BaseDAO <T extends AbstractModel> {


        Collection<T> getAll();

        T findById(Long id);

        T update(T model);

        boolean delete(T model);
}
