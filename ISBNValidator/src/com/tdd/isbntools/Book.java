package com.tdd.isbntools;

/**
 * @author leiduanchn
 * @create 2019-12-08 9:45 p.m.
 */
public class Book {
    private String isbn;
    private String author;
    private String title;

    public Book() {
    }

    public Book(String isbn, String author, String title) {
        this.isbn = isbn;
        this.author = author;
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }
}
