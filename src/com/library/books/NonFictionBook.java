package com.library.books;

import com.library.authors.Author;

public class NonFictionBook extends Book {
    private String field;

    public NonFictionBook(String title, Author[] authors, String isbn, int year, String genre, String field) {
        super(title, authors, isbn, year, genre);
        this.field = field;
    }

    @Override
    public void displayBook() {
        super.displayBook();
        System.out.println("Field: " + field);
    }
}
