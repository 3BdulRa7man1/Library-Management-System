package com.library.authors;

public class NovelistAuthor extends Author {
    private String genre;

    public NovelistAuthor(String name, String birthday, String genre) {
        super(name, birthday);
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public void displayAuthor() {
        super.displayAuthor();
        System.out.println("Genre: " + genre);
    }
}
