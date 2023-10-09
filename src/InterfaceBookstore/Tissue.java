package InterfaceBookstore;

import java.util.Scanner;

public class Tissue implements Manageable{

    // member variables
    String name;
    int nSheets;
    int price;

    @Override
    public Manageable read(Scanner scanner) {
        name = scanner.next();
        nSheets = scanner.nextInt();
        price = scanner.nextInt();
        return this;
    }

    @Override
    public void print() {
        System.out.printf("%s (%d매) [%d원]\n", name, nSheets, price);
    }

    @Override
    public boolean matches(String kwd) {
        return name.contains(kwd) || String.valueOf(nSheets).equals(kwd) || String.valueOf(price).equals(kwd);
    }
}
