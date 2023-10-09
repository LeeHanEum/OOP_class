package InterfaceBookstore;

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
    String fileName = "src/InterfaceBookstore/book.txt";
    List <Manageable> sellList = new ArrayList<>();

    // main
    public static void main(String[] args) {
        System.out.println("서점 상품 관리 프로그램");
        new Bookstore().run();
    }

    // run menu
    private void run(){
        readAll(fileName);
        printAll();
        search();
    }

    // read methods
    private void readAll(String fileName){
        fileScanner = openFile(fileName);
        System.out.println("\n상품 정보를 입력하세요.");
        Manageable item = null;
        while(fileScanner.hasNext()){
            int n = fileScanner.nextInt();
            switch (n){
                case 1: item = new Book(); break;
                case 2: item = new EBook(); break;
                case 3: item = new AppendixBook(); break;
                case 4: item = new Pen(); break;
                case 5: item = new Tissue(); break;
                default: System.out.println("잘못된 입력입니다.");
            }
            assert item != null;
            item.read(fileScanner);
            sellList.add(item);
        }
        fileScanner.close();
    }

    // print methods
    private void printAll(){
        System.out.println("\n상품 목록");
        for (Manageable item : sellList) {
            item.print();
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
                for (Manageable item : sellList) {
                    if (item instanceof EBook) item.print();
                }
            }else if (kwd.equals("부록책")) {
                System.out.println("\n검색 결과");
                for (Manageable item : sellList) {
                    if (item instanceof AppendixBook) item.print();
                }
                continue;
            }

            System.out.println("\n검색 결과");
            for (Manageable item : sellList) {
                if (item.matches(kwd)) item.print();
            }
        }
    }
}
