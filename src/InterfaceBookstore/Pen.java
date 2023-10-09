package InterfaceBookstore;

import java.util.Scanner;

public class Pen implements Manageable{

    // member variables
    String name;
    float mmThick;
    int price;

    @Override
    public Manageable read(Scanner scanner) {
        name = scanner.next();
        mmThick = scanner.nextFloat();
        price = scanner.nextInt();
        return this;
    }

    @Override
    public void print() {
        System.out.printf("%s (%.1fmm) [%d원]\n", name, mmThick, price);
    }

    @Override
    public boolean matches(String kwd) {
        return name.contains(kwd) || String.valueOf(mmThick).equals(kwd) || String.valueOf(price).equals(kwd);
    }
}
