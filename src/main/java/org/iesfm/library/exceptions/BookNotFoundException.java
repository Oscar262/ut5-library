package org.iesfm.library.exceptions;

public class BookNotFoundException extends Exception{
    private String isbn;

    public BookNotFoundException(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }
}
