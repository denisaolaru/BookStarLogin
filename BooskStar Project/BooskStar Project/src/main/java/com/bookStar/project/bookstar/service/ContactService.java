package com.bookStar.project.bookstar.service;

import com.bookStar.project.bookstar.dao.ContactDAO;
import com.bookStar.project.bookstar.domain.Contact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ContactService {
    private static final Logger LOGGER = LoggerFactory.getLogger ( ContactService.class );

    @Autowired
    private ContactDAO contactDAO;

    public ContactDAO getContactDAO () {
        return contactDAO;
    }

    public void setContactDAO ( ContactDAO contactDAO ) {
        this.contactDAO = contactDAO;
    }

    public Collection<Contact> listAll () {
        return contactDAO.getAll ( );
    }


    public boolean delete ( Long id ) {
        LOGGER.debug ( "Deleting contact with id: " + id );
        Contact contact = contactDAO.findById ( id );
        if ( contact != null ) {
            contactDAO.delete ( contact );
            return true;
        }

        return false;
    }

    public Contact findById ( long id ) {
        return contactDAO.findById ( id );
    }


    public void save ( Contact contact ) throws ValidationException {
        LOGGER.debug ( "Saving: " + contact );

        contactDAO.update ( contact );
    }
}
