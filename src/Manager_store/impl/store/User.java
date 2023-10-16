package Manager_store.impl.store;

import Manager_store.manager.Manageable;

import java.util.ArrayList;
import java.util.Scanner;

public class User implements Manageable {
    String id;
    String pwd;
    int point;
    ArrayList<Manageable> myOrder = new ArrayList<>();

    public int getTotal() {
        int total = 0;
        for (Manageable order : myOrder){
            total += ((Order)order).total;
        }
        return total;
    }

    public int getPoint(){
        int point = this.point;
        for (Manageable order : myOrder){
            point += ((Order)order).point;
        }
        return point;
    }

    @Override
    public void read(Scanner scan) {
        id = scan.next();
        pwd = scan.next();
        point = scan.nextInt();
    }

    @Override
    public boolean matches(String kwd) {
        if (id.equals(kwd))
            return true;
        if (pwd.equals(kwd))
            return true;
        for (Manageable m : myOrder){
            if (m.matches(kwd))
                return true;
        }
        return false;
    }

    @Override
    public void print() {
        System.out.printf("[%s] %d회 총구매액 %d원 (포인트 %d원)\n", id, myOrder.size(), getTotal(), getPoint());
        for (Manageable order : myOrder){
            order.print();
        }
    }
}
