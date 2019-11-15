package com.bookStar.project.bookstar.domain;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class Books extends AbstractModel{

        @NotEmpty(message = "The Title of the book is mandatory")
        @Length(min = 2)
        private String title;

        @NotEmpty(message = "The Author of the book is mandatory")
        @Length(min = 3)
        private String author;

        private String genre;

        @NotEmpty(message = "The Language of the book is mandatory")
        @Length(min = 3)
        private String language;

        private double price;

        private int year;

        private String photopath;

        private String singlePath;



    public String getSinglePath() {
        return singlePath;
    }

    public void setSinglePath(String singlePath) {
        this.singlePath = singlePath;
    }

    public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public String getPhotopath() {
            return photopath;
        }

        public void setPhotopath(String photopath) {
            this.photopath = photopath;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getGenre() {
            return genre;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    @Override
    public String toString() {
        return "Books{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", language='" + language + '\'' +
                ", photopath='" + photopath + '\'' +
                ", price=" + price +
                ", year=" + year +
                ", singlePath='" + singlePath + '\'' +
                '}';
    }
}



