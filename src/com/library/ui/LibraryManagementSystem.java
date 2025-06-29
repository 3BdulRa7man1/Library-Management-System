package com.library.ui;

import com.library.authors.*;
import com.library.books.*;
import com.library.core.Library;

import java.util.Scanner;

public class LibraryManagementSystem {
    public static boolean isValidString(String input) {
        return input != null && input.matches("[A-Za-z .'-]+");
    }

    public static boolean isValidYear(int year) {
        return year >= 1000 && year <= 9999;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Display Book by Title");
            System.out.println("3. Search Books by Author");
            System.out.println("4. display All Books");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            String input = scanner.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number from 1 to 4.");
                continue;
            }

            switch (choice) {
                case 1:
                    if (library.isFull()) {
                        System.out.println("Library is full.");
                        break;
                    }

                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    if (!isValidString(title)) {
                        System.out.println("Invalid title.");
                        break;
                    }

                    System.out.print("Enter number of authors: ");
                    int numAuthors;
                    try {
                        numAuthors = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number.");
                        break;
                    }

                    Author[] authors = new Author[numAuthors];
                    for (int i = 0; i < numAuthors; i++) {
                        System.out.println("1. General Author\n2. Novelist Author\n3. Poet Author");
                        System.out.print("Choose author type for author " + (i + 1) + ": ");
                        int type;
                        try {
                            type = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid type.");
                            break;
                        }

                        System.out.print("Enter name: ");
                        String name = scanner.nextLine();
                        if (!isValidString(name)) {
                            System.out.println("Invalid name.");
                            break;
                        }

                        System.out.print("Enter birthday (e.g., 1990-01-01): ");
                        String birthday = scanner.nextLine();
                        if (!birthday.matches("\\d{4}-\\d{2}-\\d{2}")) {
                            System.out.println("Invalid birthday format.");
                            break;
                        }

                        if (type == 2) {
                            System.out.print("Enter genre: ");
                            String genre = scanner.nextLine();
                            authors[i] = new NovelistAuthor(name, birthday, genre);
                        } else if (type == 3) {
                            System.out.print("Enter poetry style: ");
                            String style = scanner.nextLine();
                            authors[i] = new PoetAuthor(name, birthday, style);
                        } else {
                            authors[i] = new Author(name, birthday);
                        }
                    }

                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();

                    System.out.print("Enter publication year: ");
                    int year;
                    try {
                        year = Integer.parseInt(scanner.nextLine());
                        if (!isValidYear(year)) {
                            System.out.println("Invalid year.");
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid year.");
                        break;
                    }

                    System.out.print("Enter genre: ");
                    String genre = scanner.nextLine();

                    System.out.println("1. Fiction Book\n2. Non-Fiction Book");
                    System.out.print("Choose book type: ");
                    int bookType;
                    try {
                        bookType = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid type.");
                        break;
                    }

                    Book book;
                    if (bookType == 1) {
                        System.out.print("Enter fiction type: ");
                        String fictionType = scanner.nextLine();
                        book = new FictionBook(title, authors, isbn, year, genre, fictionType);
                    } else if (bookType == 2) {
                        System.out.print("Enter field: ");
                        String field = scanner.nextLine();
                        book = new NonFictionBook(title, authors, isbn, year, genre, field);
                    } else {
                        System.out.println("Invalid book type.");
                        break;
                    }

                    library.addBook(book);
                    System.out.println("Book added.");
                    break;

                case 2:
                    System.out.print("Enter book title to display: ");
                    String searchTitle = scanner.nextLine();
                    library.displayBookByTitle(searchTitle);
                    break;

                case 3:
                    System.out.print("Enter author name to search: ");
                    String searchName = scanner.nextLine();
                    library.searchBooksByAuthor(searchName);
                    break;
                case 4:
                    library.displayAllBooks();
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
