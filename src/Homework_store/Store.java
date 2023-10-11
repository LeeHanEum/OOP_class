package Homework_store;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Store {

    // member variables
    Scanner scan = new Scanner(System.in);
    static ArrayList<Manageable> itemList = new ArrayList<>();
    static ArrayList<Manageable> userList = new ArrayList<>();
    static ArrayList<Manageable> orderList = new ArrayList<>();

    // main
    public static void main(String[] args) {
        Store store = new Store();
        store.run();
    }

    void run() {
        readAll(itemList, "src/Homework_store/item.txt", "item");
        readAll(userList, "src/Homework_store/user.txt", "user");
        readAll(orderList, "src/Homework_store/order.txt", "order");
        menu();
    }

    // menu methods
    void menu() {
        int num;
        while (true) {
            System.out.print("(1)물품출력 (2)사용자출력 (3)주문출력 (4)검색 (0) 종료 ");
            num = scan.nextInt();
            switch(num) {
                case 1: printAll(itemList); break;
                case 2: printAll(userList); break;
                case 3: printAll(orderList); break;
                case 4: searchMenu(); break;
                case 0: return;
                default: break;
            }
        }
    }
    void searchMenu() {
        int num;
        while (true) {
            System.out.print("(1)물품검색 (2)사용자검색 (3)주문검색 (4)조건검색 (0) 종료 ");
            num = scan.nextInt();
            switch(num) {
                case 1: searchAll(itemList); break;
                case 2: searchAll(userList); break;
                case 3: searchAll(orderList); break;
                case 4: searchAll(); break;
                case 0 : return;
                default: break;
            }
        }
    }

    // read & print methods
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
                case "order":
                    m = new Order();
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

    // search & find methods
    static Manageable findByKwd(ArrayList<Manageable> list, String kwd) {
        for (Manageable m: list) {
            if (m.matches(kwd))
                return m;
        }
        return null;
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
    public void searchAll(){
        while(true) {
            System.out.println("조건 검색할 요소를 선택하세요.");
            System.out.println("(1)구매총액 (2)구매횟수 (3)포인트 (0)종료");
            int num = scan.nextInt();
            String type = null;
            switch (num) {
                case 1 : type = "total"; break;
                case 2 : type = "count"; break;
                case 3 : type = "point"; break;
                case 0 : return;
            }
            System.out.println("조건값을 입력하고 up 또는 down을 입력하세요. (예 : 100 up) >> ");
            int value = scan.nextInt();
            String updown = scan.next();
            switch (updown) {
                case "up" : searchAll(type, value, true); break;
                case "down" : searchAll(type, value, false); break;
            }
        }
    }
    public void searchAll(String type, int value, Boolean bool){
        for (Manageable m: userList) {
            User user = (User)m;
            switch (type) {
                case "total":
                    if (bool) {
                        if (user.getTotal() >= value)
                            user.print();
                    } else {
                        if (user.getTotal() <= value)
                            user.print();
                    }
                    break;
                case "count":
                    if (bool) {
                        if (user.getCount() > value)
                            user.print();
                    } else {
                        if (user.getCount() < value)
                            user.print();
                    }
                    break;
                case "point":
                    if (bool) {
                        if (user.getPoint() >= value)
                            user.print();
                    } else {
                        if (user.getPoint() <= value)
                            user.print();
                    }
                    break;
            }
        }
    }
}

