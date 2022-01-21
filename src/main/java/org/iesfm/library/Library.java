package org.iesfm.library;

import org.iesfm.library.exceptions.BookNotFoundException;
import org.iesfm.library.exceptions.MemberNotFoundException;

import java.util.Arrays;
import java.util.Objects;

public class Library implements ILibrary {
    private String name;
    private Book[] books;
    private Member[] members;
    private BookLend[] lends;


    @Override
    public Book returnBookWithISBN(String isbn) throws BookNotFoundException {
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                return book;
            }
        }
        throw new BookNotFoundException(isbn);
    }

    @Override
    public Member returnMemberWithNIF(String nif) throws MemberNotFoundException {
        for (int i = 0; i < members.length; i++) {
            Member member = members[i];
            if (member.getNif().equalsIgnoreCase(nif)) {
                return member;
            }
        }
        throw new MemberNotFoundException(nif);
    }

    @Override
    public boolean booksMemberLend(String nif, String isbn) throws BookNotFoundException, MemberNotFoundException {
        Member member = returnMemberWithNIF(nif);
        Book book = returnBookWithISBN(isbn);
        for (int i = 0; i < lends.length; i++) {
            BookLend bookLend = lends[i];
            if (bookLend.getMemberNif().equalsIgnoreCase(nif) &&
                    bookLend.getIsbn().equalsIgnoreCase(isbn)) {
                return true;
            }
        }
        return false;
    }


    public Library(String name, Book[] books, Member[] members, BookLend[] lends) {
        this.name = name;
        this.books = books;
        this.members = members;
        this.lends = lends;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public Member[] getMembers() {
        return members;
    }

    public void setMembers(Member[] members) {
        this.members = members;
    }

    public BookLend[] getlends() {
        return lends;
    }

    public void setLends(BookLend[] lends) {
        this.lends = lends;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return Objects.equals(name, library.name) && Arrays.equals(books, library.books) && Arrays.equals(members, library.members) && Arrays.equals(lends, library.lends);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name);
        result = 31 * result + Arrays.hashCode(books);
        result = 31 * result + Arrays.hashCode(members);
        result = 31 * result + Arrays.hashCode(lends);
        return result;
    }

    @Override
    public String toString() {
        return "org.iesf.library.Library{" +
                "name='" + name + '\'' +
                ", books=" + Arrays.toString(books) +
                ", members=" + Arrays.toString(members) +
                ", loans=" + Arrays.toString(lends) +
                '}';
    }

}
