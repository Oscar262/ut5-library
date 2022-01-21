package org.iesfm.library;

import java.util.Objects;

public class BookLend {

    private String isbn;
    private String lendDate;
    private String returnDate;
    private String memberNif;




    public BookLend(String isbn, String lendDate, String returnDate, String memberNif) {
        this.isbn = isbn;
        this.lendDate = lendDate;
        this.returnDate = returnDate;
        this.memberNif = memberNif;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getLendDate() {
        return lendDate;
    }

    public void setLendDate(String lendDate) {
        this.lendDate = lendDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getMemberNif() {
        return memberNif;
    }

    public void setMemberNif(String memberNif) {
        this.memberNif = memberNif;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookLend bookLend = (BookLend) o;
        return Objects.equals(isbn, bookLend.isbn) && Objects.equals(lendDate, bookLend.lendDate) && Objects.equals(returnDate, bookLend.returnDate) && Objects.equals(memberNif, bookLend.memberNif);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, lendDate, returnDate, memberNif);
    }

    @Override
    public String toString() {
        return "org.iesf.library.BookLend{" +
                "isbn='" + isbn + '\'' +
                ", lendDate='" + lendDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                ", memberNif='" + memberNif + '\'' +
                '}';
    }
}
