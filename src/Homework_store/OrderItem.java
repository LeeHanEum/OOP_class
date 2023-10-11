package Homework_store;


import java.util.Scanner;

public class OrderItem implements Manageable{
    Item item;
    int count;

    @Override
    public void read(Scanner scan) {
        this.count = scan.nextInt();
    }

    @Override
    public boolean matches(String kwd) {
        if (item.matches(kwd))
            return true;
        return false;
    }

    @Override
    public void print() {

    }

    public int getSubtotal(){
        return item.price * count;
    }
}
