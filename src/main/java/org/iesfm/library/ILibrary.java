package org.iesfm.library;


import org.iesfm.library.exceptions.BookNotFoundException;
import org.iesfm.library.exceptions.MemberNotFoundException;

public interface ILibrary {

    Book returnBookWithISBN(String isbn)throws BookNotFoundException;
    Member returnMemberWithNIF(String nif)throws MemberNotFoundException;
    boolean booksMemberLend(String nif, String isbn)throws BookNotFoundException, MemberNotFoundException;
}
