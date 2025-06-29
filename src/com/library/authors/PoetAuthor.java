package com.library.authors;

public class PoetAuthor extends Author {
    private String style;

    public PoetAuthor(String name, String birthday, String style) {
        super(name, birthday);
        this.style = style;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    @Override
    public void displayAuthor() {
        super.displayAuthor();
        System.out.println("Poetry Style: " + style);
    }
}
