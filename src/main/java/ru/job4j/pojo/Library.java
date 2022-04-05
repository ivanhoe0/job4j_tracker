package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book cleanCode = new Book("Clean Code", 359);
        Book warAndPeace = new Book("War and Peace", 721);
        Book ivanhoe = new Book("Ivanhoe", 325);
        Book martialArts = new Book("Martial Arts", 1245);
        Book[] books = new Book[4];
        books[0] = cleanCode;
        books[1] = warAndPeace;
        books[2] = ivanhoe;
        books[3] = martialArts;
        for (Book book : books) {
            System.out.println(book.getName() + " - " + book.getNumberOfPages());
        }
        Book temp = books[3];
        books[3] = books[0];
        books[0] = temp;
        System.out.println("Book named \"Clean Code\":");
        for (int i = 0; i != books.length; i++) {
            Book bk = books[i];
            if ("Clean Code".equals(bk.getName())) {
                System.out.println(bk.getName());
            }
        }
    }
}
