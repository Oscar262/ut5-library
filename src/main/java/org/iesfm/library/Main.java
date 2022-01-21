package org.iesfm.library;


import org.iesfm.library.exceptions.BookNotFoundException;
import org.iesfm.library.exceptions.MemberNotFoundException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static int num() {
        Integer num = null;
        while (num == null) {
            try {
                num = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("El numero debe ser un entero");
            } finally {
                scanner.nextLine();
            }
        }
        return num;
    }

    static int posNum() {
        int num = num();
        while (num < 0) {
            System.out.println("El numero debe ser positivo");
            num = scanner.nextInt();
            scanner.nextLine();
        }
        return num;
    }


    static Member infoMember() {
        System.out.println("Introduce el nif del miembro");
        String nif = scanner.nextLine();
        System.out.println("Introduce el nombre del miembro");
        String name = scanner.nextLine();
        System.out.println("Introduce los apellidos del miembro");
        String surname = scanner.nextLine();
        System.out.println("Introduce el numero del miembro");
        int numMember = posNum();
        System.out.println("Introduce el codigo postal del miembro");
        int zipCode = posNum();
        return new Member(nif, name, surname, numMember, zipCode);
    }

    static Member[] arrayMember() {
        System.out.println("Escriba cuantos miembros hay");
        Member[] members = new Member[posNum()];
        for (int i = 0; i < members.length; i++) {
            Member member = infoMember();
            members[i] = member;
        }
        return members;
    }

    static Book infoBook() {
        System.out.println("Introduce el titulo del libro");
        String title = scanner.nextLine();
        System.out.println("Introduce el autor del libro");
        String author = scanner.nextLine();
        System.out.println("Introduce el isbn del libro");
        String isbn = scanner.nextLine();
        System.out.println("Introduce los generos del libro separados por comas");
        String allGenres = scanner.nextLine();
        String[] genres = allGenres.split(",");
        return new Book(title, author, isbn, genres);
    }

    static Book[] arrayBooks() {
        System.out.println("Escriba cuantos libros hay");
        Book[] books = new Book[posNum()];
        for (int i = 0; i < books.length; i++) {
            Book book = infoBook();
            books[i] = book;
        }
        return books;
    }

    static BookLend infoBookLend() {
        System.out.println("Introduce el isbn");
        String isbn = scanner.nextLine();
        System.out.println("Introduce la fecha en la que se realizó el prestamo");
        String lendDate = scanner.nextLine();
        System.out.println("Introduce la fecha en la que se devolvio el libro");
        String returnDate = scanner.nextLine();
        System.out.println("Introduce el nif del miembro");
        String memberNif = scanner.nextLine();
        return new BookLend(isbn, lendDate, returnDate, memberNif);
    }

    static BookLend[] arrayBookLends() {
        System.out.println("Introduce cuantos prestamos hay");
        BookLend[] bookLends = new BookLend[posNum()];
        for (int i = 0; i < bookLends.length; i++) {
            BookLend bookLend = infoBookLend();
            bookLends[i] = bookLend;
        }
        return bookLends;
    }

    static Library infoLibrary() {
        System.out.println("Introduce el nombre de la librería");
        String name = scanner.nextLine();
        Book[] books = arrayBooks();
        Member[] members = arrayMember();
        BookLend[] bookLends = arrayBookLends();
        return new Library(name, books, members, bookLends);
    }

    public static void main(String[] args) {
        Library library = infoLibrary();
        try {
            System.out.println("Introduce un NIF para buscar un miembro");
            Member member = library.returnMemberWithNIF(scanner.nextLine());
            System.out.println(member.getName());
        } catch (MemberNotFoundException e) {
            System.out.println("No se ha encontrado el miembro");
        }
        try {
            System.out.println("Introduce un ISBN para buscar el libro");
            Book book = library.returnBookWithISBN(scanner.nextLine());
            System.out.println(book.getTitle());
        } catch (BookNotFoundException e) {
            System.out.println("No se ha encontrado el libro");
        }
        try {
            System.out.println("Introduce un NIF");
            String nif = scanner.nextLine();
            String isbn = scanner.nextLine();
            System.out.println("y un ISBN para buscar un prestamo");
            boolean bookLend = library.booksMemberLend(nif, isbn);
            if (bookLend) {
                System.out.println("El prestamo existe");
            }
        } catch (MemberNotFoundException e) {
            System.out.println("No se ha encontrado al miembro");
        } catch (BookNotFoundException e) {
            System.out.println("No se ha encontrado el libro");
        }
    }

}