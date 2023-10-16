package Manager_store.impl.store;

import Manager_store.manager.Factory;
import Manager_store.manager.Manageable;
import Manager_store.manager.Manager;

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

    static Manager itemMgr = new Manager();
    static Manager userMgr = new Manager();
    static Manager orderMgr = new Manager();

    // main
    public static void main(String[] args) {
        Store store = new Store();
        store.run();
    }

    void run () {
        itemMgr.readAll("src/Manager_store/store/input/item.txt", new Factory() {
            @Override
            public Manageable create() {
                return new Item();
            }
        });
        itemMgr.printAll();
        userMgr.readAll("src/Manager_store/store/input/user.txt", new Factory() {
            @Override
            public Manageable create() {
                return new User();
            }
        });
        userMgr.printAll();
        orderMgr.readAll("src/Manager_store/store/input/order.txt", new Factory() {
            @Override
            public Manageable create() {
                return new Order();
            }
        });
        orderMgr.printAll();
        searchMenu();
    }

    // menu methods
    void searchMenu() {

    }

    // search & find methods
    static Manageable findByKwd(ArrayList<Manageable> list, String kwd) {
        for (Manageable m: list) {
            if (m.matches(kwd))
                return m;
        }
        return null;
    }


}

