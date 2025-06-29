package com.library.core;

import com.library.books.Book;
import com.library.authors.Author;

public class Library {
    private Book[] books;
    private int bookCount;

    public Library() {
        books = new Book[100];
        bookCount = 0;
    }

    public boolean isFull() {
        return bookCount >= books.length;
    }

    public boolean isEmpty() {
        return bookCount == 0;
    }

    public void addBook(Book b) {
        if (!isFull()) {
            books[bookCount++] = b;
        } else {
            System.out.println("Library is full.");
        }
    }

    public void displayBookByTitle(String title) {
        if (isEmpty()) {
            System.out.println("Library is empty.");
            return;
        }
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                books[i].displayBook();
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void searchBooksByAuthor(String authorName) {
        if (isEmpty()) {
            System.out.println("Library is empty.");
            return;
        }
        boolean found = false;
        for (int i = 0; i < bookCount; i++) {
            Author[] authors = books[i].getAuthors();
            for (Author author : authors) {
                if (author.getName().equalsIgnoreCase(authorName)) {
                    books[i].displayBook();
                    found = true;
                    break;
                }
            }
        }
        if (!found) {
            System.out.println("No books found for this author.");
        }
    }
    public void displayAllBooks() {
        if (isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }
        for (int i = 0; i < bookCount; i++) {
            books[i].displayBook();
            System.out.println("-------------------------");
        }
    }
}
