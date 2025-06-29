package com.library.authors;

public class Author {
    private String name;
    private String birthday;

    public Author() {
        this.name = "Unknown";
        this.birthday = "";
    }

    public Author(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void displayAuthor() {
        System.out.println("Author: " + name + ", Birthday: " + birthday);
    }
}
