package org.iesfm.library;

import org.iesfm.library.exceptions.BookNotFoundException;
import org.iesfm.library.exceptions.MemberNotFoundException;
import org.junit.Assert;
import org.junit.Test;

public class LibraryTest {

    private Library library = createLibrary();

    @Test
    public void bookFoundTest() throws BookNotFoundException {
        Book book = library.returnBookWithISBN("10");
        Assert.assertEquals("title", book.getTitle());
    }

    @Test(expected = BookNotFoundException.class)
    public void bookNotFoundTest() throws BookNotFoundException {
        Book book = library.returnBookWithISBN("9");
    }

    @Test
    public void memberFoundTest() throws MemberNotFoundException {
        Member member = library.returnMemberWithNIF("nif1");
        Assert.assertEquals("name", member.getName());
    }

    @Test(expected = MemberNotFoundException.class)
    public void memberNotFoundTest() throws MemberNotFoundException {
        Member member = library.returnMemberWithNIF("nif5");
    }

    @Test
    public void bookLendFoundTest() throws MemberNotFoundException, BookNotFoundException {
        boolean exist = library.booksMemberLend("nif1", "10");
        Assert.assertTrue(exist);
    }

    @Test(expected = MemberNotFoundException.class)
    public void bookLendNotMemberFoundTest() throws MemberNotFoundException, BookNotFoundException {
        boolean exist = library.booksMemberLend("nif10", "10");
    }

    @Test(expected = BookNotFoundException.class)
    public void bookLendNotBookFoundTest() throws MemberNotFoundException, BookNotFoundException {
        boolean exist = library.booksMemberLend("nif1", "100");
    }


    private Library createLibrary() {
        String[] genres = new String[]{
                "genero1", "genero2"
        };

        String name = "biblioteca";
        Book[] books = new Book[]{
                new Book("title", "autor", "10", genres),
                new Book("title2", "autor2", "11", genres)
        };

        Member[] members = new Member[]{
                new Member("nif1", "name", "surname", 1, 12),
                new Member("nif2", "name2", "surname2", 2, 12),
        };

        BookLend[] bookLends = new BookLend[]{
                new BookLend("10", "12-10", "13-10", "nif2"),
                new BookLend("10", "4", "3", "nif1")
        };

        return new Library(name, books, members, bookLends);
    }

}
