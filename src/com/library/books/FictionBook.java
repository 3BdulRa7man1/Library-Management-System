package com.library.books;

import com.library.authors.Author;

public class FictionBook extends Book {
    private String fictionType;

    public FictionBook(String title, Author[] authors, String isbn, int year, String genre, String fictionType) {
        super(title, authors, isbn, year, genre);
        this.fictionType = fictionType;
    }

    @Override
    public void displayBook() {
        super.displayBook();
        System.out.println("Fiction Type: " + fictionType);
    }
}
