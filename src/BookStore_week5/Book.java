package BookStore_week5;

import java.util.ArrayList;
import java.util.Scanner;

public class Book {

    // member variables
    String name;
    String pub;
    String isbn;
    int year;
    ArrayList<String> authorList;
    int price;

    // read method
    protected Book read(Scanner scanner){
        name = scanner.next();
        pub = scanner.next();
        isbn = scanner.next();
        year = scanner.nextInt();
        authorList = new ArrayList<>();
        String author;
        while(true){
            author = scanner.next();
            if(author.equals("0")) break;
            authorList.add(author);
        }
        price = scanner.nextInt();
        return this;
    }

    // print method
    protected void printBookType(){
        System.out.print("[일반책] ");
    }
    protected void print(){
        printBookType();
        System.out.printf("%s (%s/%s/%d년) [%d원]\t", name, pub, isbn, year, price);
        System.out.print("저자:");
        for(String author : authorList){
            System.out.print(author + " ");
        }
        System.out.println();
    }

    // search method
    protected boolean matches(String kwd){
        return name.contains(kwd) || pub.contains(kwd) || isbn.equals(kwd) || String.valueOf(year).equals(kwd) || authorList.contains(kwd) || String.valueOf(price).equals(kwd);
    }
}
