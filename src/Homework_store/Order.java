package Homework_store;

import java.util.ArrayList;
import java.util.Scanner;

public class Order implements Manageable{

    // member variables
    int orderId;
    User user;
    String date;
    int point;
    int total;
    ArrayList<OrderItem> orderItemList = new ArrayList<>();

    public void calcTotal(){
        total = 0;
        for (OrderItem orderItem: orderItemList) {
            total += orderItem.getSubtotal();
        }
    }

    public void calcPoint(){
        point = (int)(total * 0.05);
    }

    @Override
    public void read(Scanner scanner) {
        this.orderId = scanner.nextInt();
        this.user = (User)Store.findByKwd(Store.userList, scanner.next());
        this.date = scanner.next();
        String code;
        while (true){
            code = scanner.next();
            if (code.equals("0")) break;
            OrderItem orderItem = new OrderItem();
            orderItem.item = (Item)Store.findByKwd(Store.itemList, code);
            orderItem.read(scanner);
            orderItemList.add(orderItem);
        }
        calcTotal();
        calcPoint();
        user.myOrder.add(this);
    }

    @Override
    public boolean matches(String kwd) {
        if (String.valueOf(orderId).equals(kwd))
            return true;
        if (user.id.equals(kwd))
            return true;
        if (date.contains(kwd))
            return true;
        for (OrderItem orderItem: orderItemList) {
            if (orderItem.matches(kwd))
                return true;
        }
        return false;
    }

    @Override
    public void print() {
        System.out.printf("\t[주문 아이디: %d] %s 사용자: %s -주문금액: %d (포인트: %d점)\n", orderId, date, user.id, total, point);
        for (OrderItem orderItem: orderItemList) {
            System.out.printf("\t\t%s %d x %d개 = %d원\n", orderItem.item.name, orderItem.item.price, orderItem.count, orderItem.item.price * orderItem.count);
        }
    }
}
