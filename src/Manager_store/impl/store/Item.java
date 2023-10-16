package Manager_store.impl.store;

import Manager_store.manager.Manageable;

import java.util.Scanner;

public class Item implements Manageable {
    int num;
    static int count = 0;
    String code;
    String name;
    int price;

    public void read(Scanner scan) {
        num = ++count;
        code = scan.next();
        name = scan.next();
        price = scan.nextInt();
    }
    public void print() {
        System.out.printf("[%d] [%s] %s\t", num,  code,  name);
        System.out.printf("%5d원\n", price);
    }
    public boolean matches(String kwd) {
        if (name.contains(kwd))
            return true;
        if (kwd.length() <= 2 && kwd.equals(""+num))
            return true;
        if (kwd.length() > 2 && code.contains(kwd))
            return true;
        return false;
    }
}
