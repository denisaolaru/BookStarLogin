package com.bookStar.project.bookstar.domain;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class Contact extends AbstractModel {

    @NotEmpty(message = "The name is mandatory")
    @Length(min = 2)
    private String name;

    @NotEmpty(message = "The email is mandatory")
    @Length(min = 2)
    private String email;

    private String subject;

    @NotEmpty(message = "The message is mandatory")
    @Length(min = 2)
    private String message;

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail ( String email ) {
        this.email = email;
    }

    public String getSubject () {
        return subject;
    }

    public void setSubject ( String subject ) {
        this.subject = subject;
    }

    public String getMessage () {
        return message;
    }

    public void setMessage ( String message ) {
        this.message = message;
    }

    @Override
    public String toString () {
        return "Contact{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}

