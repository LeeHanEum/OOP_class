package ItemStore_week5;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Store {
    Scanner scan = new Scanner(System.in);
    static ArrayList<Manageable> itemList = new ArrayList<>();
    static ArrayList<Manageable> userList = new ArrayList<>();
    void run() {
        readAll(itemList, "src/ItemStore_week5/item.txt", "item");
        readAll(userList, "src/ItemStore_week5/user.txt", "user");
        menu();
    }

    void menu() {
        int num;
        while (true) {
            System.out.print("(1)물품출력 (2)사용자출력 (3)검색 (기타) 종료 ");
            num = scan.nextInt();
            if (num < 1 || num > 3) break;
            switch(num) {
                case 1: printAll(itemList); break;
                case 2: printAll(userList); break;
                case 3: searchMenu(); break;
                default: break;
            }
        }
    }
    void searchMenu() {
        int num;
        while (true) {
            System.out.print("(1)물품검색 (2)사용자검색 (기타) 종료 ");
            num = scan.nextInt();
            if (num < 1 || num > 2) break;
            switch(num) {
                case 1: searchAll(itemList); break;
                case 2: searchAll(userList); break;
                default: break;
            }
        }
    }

    Scanner openFile(String filename) {
        Scanner filein = null;
        try {
            filein = new Scanner(new File(filename));
        } catch (IOException e)
        {
            System.out.println("파일 입력 오류");
            System.exit(0);
        }
        return filein;
    }

    static Manageable findItem(String kwd) {
        for (Manageable m: itemList) {
            if (m.matches(kwd))
                return m;
        }
        return null;
    }

    public static void main(String[] args) {
        Store store = new Store();
        store.run();
    }

    public void readAll(ArrayList<Manageable> list, String filename, String type) {
        Scanner filein = openFile(filename);
        Manageable m = null;
        while (filein.hasNext()) {
            switch (type) {
                case "item":
                    m = new Item();
                    break;
                case "user":
                    m = new User();
                    break;
                default:
                    break;
            }
            assert m != null;
            m.read(filein);
            list.add(m);
        }
    }

    public void printAll(ArrayList<Manageable> list) {
        for (Manageable m: list) {
            m.print();
        }
    }

    public void searchAll(ArrayList<Manageable> list){
        String kwd = null;
        while (true) {
            System.out.print(">> ");
            kwd = scan.next();
            if (kwd.contentEquals("end"))
                break;
            for (Manageable m: list) {
                if (m.matches(kwd))
                    m.print();
            }
        }
    }
}

