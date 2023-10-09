package BookStore_week5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bookstore {

    // Scanner
    Scanner openFile(String fileName) {
        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("File not found : " + fileName);
            System.exit(0);
        }
        return fileScanner;
    }
    Scanner scanner = new Scanner(System.in);
    Scanner fileScanner;

    // member variables
    String fileName = "src/BookStore_week5/book.txt";
    List<Book> bookList = new ArrayList<>();

    // main
    public static void main(String[] args) {
        System.out.println("도서 관리 프로그램");
        new Bookstore().run();
    }

    // run menu
    private void run(){
        readAllBooks(fileName);
        printAllBooks();
        search();
    }

    // read methods
    private void readAllBooks(String fileName){
        fileScanner = openFile(fileName);
        System.out.println("\n도서 정보를 입력하세요.");
        Book book = null;
        while(fileScanner.hasNext()){
            int n = fileScanner.nextInt();
            switch (n){
                case 1: book = new Book(); break;
                case 2: book = new EBook(); break;
                case 3: book = new AppendixBook(); break;
                default: System.out.println("잘못된 입력입니다.");
            }
            assert book != null;
            book.read(fileScanner);
            bookList.add(book);
        }
        fileScanner.close();
    }

    // print methods
    private void printAllBooks(){
        System.out.println("\n도서 목록");
        for(Book book : bookList){
            book.print();
        }
    }

    // search methods
    private void search() {
        while (true) {
            System.out.print("\n검색할 키워드를 입력하세요 (종료 : end) : ");
            String kwd = scanner.next();
            if (kwd.equals("end")) return;

            if(kwd.equals("전자책")){
                System.out.println("\n검색 결과");
                for (Book book : bookList) {
                    if (book instanceof EBook) book.print();
                }
            }else if (kwd.equals("부록책")) {
                System.out.println("\n검색 결과");
                for (Book book : bookList) {
                    if (book instanceof AppendixBook) book.print();
                }
                continue;
            }

            System.out.println("\n검색 결과");
            for (Book book : bookList) {
                if (book.matches(kwd)) book.print();
            }
        }
    }
}
