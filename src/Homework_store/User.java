package Homework_store;

import com.sun.org.glassfish.gmbal.ManagedAttribute;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User implements Manageable {
    String id;
    String pwd;
    int point;

    ArrayList<Manageable> basket = new ArrayList<>();

    public int getCount() {
        int count = 0;
        for (Manageable m : Store.orderList){
            if (((Order)m).user.id.equals(id))
                count++;
        }
        return count;
    }

    public int getTotal() {
        int total = 0;
        for (Manageable m : Store.orderList){
            Order order = (Order)m;
            if (order.user.id.equals(id))
                total += order.total;
        }
        return total;
    }

    public int getPoint() {
        int point = 0;
        for (Manageable m : Store.orderList){
            Order order = (Order)m;
            if (order.user.id.equals(id))
                point += order.point;
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
        for (Manageable item: basket) {
            if (item.matches(kwd))
                return true;
        }
        for (Manageable item : Store.orderList){
            Order order = (Order)item;
            if (order.user.id.equals(id) && order.matches(kwd))
                return true;
        }
        return false;
    }
    @Override
    public void print() {
        System.out.printf("[%s] %d회 총구매액 %d원 (포인트 %d원)\n", id, getCount(), getTotal(), getPoint());
        for (Manageable m : Store.orderList){
            Order order = (Order)m;
            if (order.user.id.equals(id))
                order.print();
        }
    }
}
