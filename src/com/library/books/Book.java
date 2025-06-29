package com.library.books;

import com.library.authors.Author;

public class Book {
    protected String title;
    protected Author[] authors;
    protected String isbn;
    protected int year;
    protected String genre;

    public Book() {
        this.title = "";
        this.authors = new Author[1];
        this.isbn = "";
        this.year = 0;
        this.genre = "undefined";
    }

    public Book(String title, Author[] authors, String isbn, int year, String genre) {
        this.title = title;
        this.authors = authors;
        this.isbn = isbn;
        this.year = year;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public void displayBook() {
        System.out.println("Title: " + title);
        System.out.println("ISBN: " + isbn);
        System.out.println("Year: " + year);
        System.out.println("Genre: " + genre);
        System.out.print("Authors: ");
        for (int i = 0; i < authors.length; i++) {
            System.out.print(authors[i].getName());
            if (i < authors.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
