package org.iesfm.library;

import java.util.Arrays;
import java.util.Objects;

public class Book {

    private String title;
    private String author;
    private String isbn;
    private String[] genres;






    public Book(String title, String author, String isbn, String[] genres) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.genres = genres;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String[] getGenres() {
        return genres;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(isbn, book.isbn) && Arrays.equals(genres, book.genres);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(title, author, isbn);
        result = 31 * result + Arrays.hashCode(genres);
        return result;
    }

    @Override
    public String toString() {
        return "org.iesf.library.Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", genres=" + Arrays.toString(genres) +
                '}';
    }
}
