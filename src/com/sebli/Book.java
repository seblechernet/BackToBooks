package com.sebli;

public class Book {
    private String title;
    private String iSBN;
    private Author author;

    public Book(String title, String iSBN) {
        this.title = title;
        this.iSBN = iSBN;

    }

    public Book() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getiSBN() {
        return iSBN;
    }

    public void setiSBN(String iSBN) {
        this.iSBN = iSBN;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
