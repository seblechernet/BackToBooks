package com.sebli;

import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    public Library(){

    }
    public void system(){
        ArrayList<Author> authors = new ArrayList<>();
        ArrayList<Book> books = new ArrayList<>();
        Author author1 = new Author("Kebede", "Michael", "Keb@email.email", "1111111");
        Book book1 = new Book("Title 11", "ISBN0001");
        author1.getBooks().add(book1);
        authors.add(author1);
        books.add(book1);
        book1.setAuthor(author1);

        Author author2 = new Author("Bewketu", "Siyum", "Bewketu@email.email", "222222");
        Book book2 = new Book("Title 22", "ISBN0002");
        author2.getBooks().add(book2);
        authors.add(author2);
        books.add(book2);
        book2.setAuthor(author2);

        Author author3 = new Author("Addis", "Alemayehu", "Addis@email.email", "333333");
        Book book3 = new Book("Title 33", "ISBN0003");
        author3.getBooks().add(book3);
        authors.add(author3);
        books.add(book3);
        book3.setAuthor(author3);

        Book bookaa = new Book("Book11", "ISBN0011");
        books.add(bookaa);
        bookaa.setAuthor(author1);

        Book bookbb = new Book("Book22", "ISBN0011");
        books.add(bookbb);
        bookbb.setAuthor(author2);

        Book bookcc = new Book("Book33", "ISBN0011");
        books.add(bookcc);
        bookcc.setAuthor(author3);

        Scanner input = new Scanner(System.in);
        String choice = "";
        String lastName = "";
        String firstName = "";
        String email = "";
        String phoneNumber = "";
        String title = "";
        String iSBN = "";

        do {

            System.out.println("***MENU***:\n1.Create a book\n2.Create an Author\n" +
                    "3.Add a book to an Author\n4.List all Authors and the books that they wrote\n5.List of Book\n6.Quit\n");

            choice = input.nextLine();
            switch (choice) {
                case "1": {
                    createABook(title,input,iSBN,books,lastName,firstName,authors);
                    break;
                }
                case "2": {
                    createAnAuthor(lastName,input,firstName,email,phoneNumber,authors,books);
                    break;
                }
                case "3": {
                    addABookToAnAuthor(lastName,input,firstName,authors,books);
                    break;
                }
                case "4": {
                    listAuthors(authors);
                    break;
                }

                case "5": {
                    listBooks(books);
                    break;
                }
                case "6": {
                    System.out.println("Thank you for using this App");
                    break;
                }
                default: {
                    System.out.println("Please enter a valid input!");
                    break;
                }
            }
        } while (!choice.equalsIgnoreCase("6"));


    }




    public static Author findAuthor(String lastName, String firstName, ArrayList<Author> authors) {
        Author foundAuthor = null;
        for (Author eachAuthor : authors) {
            if (lastName.equalsIgnoreCase(eachAuthor.getLastName()) && firstName.equalsIgnoreCase(eachAuthor.getFirstName())) {
                foundAuthor = eachAuthor;
            }
        }
        return foundAuthor;
    }

    public static Author findAuthor(String lastName, String firstName, ArrayList<Author> authors, Book aBook) {
        Author foundAuthor = null;
        for (Author eachAuthor : authors) {
            if (lastName.equalsIgnoreCase(eachAuthor.getLastName()) && firstName.equalsIgnoreCase(eachAuthor.getFirstName())) {
                foundAuthor = eachAuthor;
            }
        }
        foundAuthor.getBooks().add(aBook);
        return foundAuthor;
    }

    public static Book findBook(String title, ArrayList<Book> books) {
        Book foundBook = null;
        for (Book eachBook : books) {
            if (title.equalsIgnoreCase(eachBook.getTitle())) {
                foundBook = eachBook;
            }
        }

        return foundBook;
    }

    public static void addABookToAnExistingAuthor(String lastName, String firstName, ArrayList<Author> authors, Scanner input, ArrayList<Book> books) {
        Author foundAuthor = findAuthor(lastName, firstName, authors);
        System.out.println("Enter the books that the Author Wrote here:");
        String anyOtherBooks = "";
        System.out.println("Type 'A' for a new Book and 'B' for an existing Book");
        String newOrExisting = input.nextLine();
        String title = "";
        String iSBN = "";
        if (newOrExisting.equalsIgnoreCase("A")) {
            do {
                Book aBook = new Book();
                System.out.println("Tile of the Book:");
                title = input.nextLine();
                aBook.setTitle(title);
                System.out.println("ISBN of the Book:");
                iSBN = input.nextLine();
                aBook.setiSBN(iSBN);
                foundAuthor.getBooks().add(aBook);
                System.out.println("Any other books by this author?(Yes/No)");
                anyOtherBooks = input.nextLine();

            } while (anyOtherBooks.equalsIgnoreCase("yes"));

        } else
            System.out.println("The Title:");
        title = input.nextLine();
        Book foundBook=findBook(title, books);
        foundAuthor.getBooks().add(foundBook);
        foundBook.setAuthor(foundAuthor);


    }

    public static void addABookToAnAuthor(Author author, ArrayList<Author> authors, Scanner input, ArrayList<Book> books) {
        System.out.println("Enter the books that the Author Wrote here:");
        String anyOtherBooks = "";
        System.out.println("Type 'A' for a new Book and 'B' for an existing Book");
        String newOrExisting = input.nextLine();
        String title = "";
        String iSBN = "";
        if (newOrExisting.equalsIgnoreCase("A")) {
            do {
                Book aBook = new Book();
                System.out.println("Tile of the Book:");
                title = input.nextLine();
                aBook.setTitle(title);
                System.out.println("ISBN of the Book:");
                iSBN = input.nextLine();
                aBook.setiSBN(iSBN);
                author.getBooks().add(aBook);
                System.out.println("Any other books by this author?(Yes/No)");
                anyOtherBooks = input.nextLine();
            } while (anyOtherBooks.equalsIgnoreCase("yes"));

        } else
            do {
                System.out.println("The Title:");
                title = input.nextLine();
                author.getBooks().add(findBook(title, books));
            } while (anyOtherBooks.equalsIgnoreCase("yes"));
    }

    public static void listAuthors(ArrayList<Author> authors) {
        for (Author eachAuthor : authors) {
            System.out.printf("Last Name:%s \nFirst Name:%s \nEmail Address:%s \nPhone Number:%s\n ",
                    eachAuthor.getLastName(), eachAuthor.getFirstName(), eachAuthor.getEmailAddress(), eachAuthor.getPhoneNumber());
            System.out.println("***Books Written by this Author***");
            for (Book eachBook : eachAuthor.getBooks()) {
                System.out.printf("Title:%s\nISBN:%s\n\n\n", eachBook.getTitle(), eachBook.getiSBN());

            }

        }

    }
    public static void listBooks(ArrayList<Book> books) {
        for (Book eachBook : books) {
            System.out.printf("Title:%s \nISBN:%s \n",
                    eachBook.getTitle(), eachBook.getiSBN());
            if (eachBook.getAuthor()==null){
                System.out.println("Author:NO Ahuthor");
            }
            else
                System.out.printf("Author Last Name:%s \nAuthor First Name:%s\n",eachBook.getAuthor().getLastName(),eachBook.getAuthor().getFirstName());
        }

    }
    public void createABook(String title,Scanner input,String iSBN,ArrayList<Book> books,String lastName,String firstName,ArrayList<Author> authors){
        Book aBook = new Book();
        System.out.println("Enter the Title:");
        title = input.nextLine();
        aBook.setTitle(title);
        System.out.println("Enter the ISBN:");
        iSBN = input.nextLine();
        aBook.setiSBN(iSBN);
        books.add(aBook);
        System.out.println("Does this book have an Author(Yes/No)");
        String haveAuthor = input.nextLine();
        if (haveAuthor.equalsIgnoreCase("yes")) {
            System.out.println("Enter the Last Name here:");
            lastName = input.nextLine();
            System.out.println("Enter the First Name here:");
            firstName = input.nextLine();
            aBook.setAuthor(findAuthor(lastName, firstName, authors, aBook));

        } else
            System.out.println("Author not found");


    }
    public void createAnAuthor(String lastName,Scanner input,String firstName,String email,String phoneNumber,ArrayList<Author> authors,ArrayList<Book> books){
        Author anAuthor = new Author();
        System.out.println("Enter the Last Name:");
        lastName = input.nextLine();
        anAuthor.setLastName(lastName);
        System.out.println("Enter the First Name:");
        firstName = input.nextLine();
        anAuthor.setFirstName(firstName);
        System.out.println("Enter Email Address:");
        email = input.nextLine();
        anAuthor.setEmailAddress(email);
        System.out.println("Enter Phone Number:");
        phoneNumber = input.nextLine();
        anAuthor.setPhoneNumber(phoneNumber);
        authors.add(anAuthor);
        addABookToAnAuthor(anAuthor, authors, input, books);

    }
    public void addABookToAnAuthor(String lastName,Scanner input,String firstName,ArrayList<Author> authors,ArrayList<Book> books){
        System.out.println("Last Name of the Author:");
        lastName = input.nextLine();
        System.out.println("First Name of the Author:");
        firstName = input.nextLine();
        addABookToAnExistingAuthor(lastName, firstName, authors, input, books);
    }
}
