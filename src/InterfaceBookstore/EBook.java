package InterfaceBookstore;

import java.util.Scanner;

public class EBook extends Book{

    // member variables
    String url;
    String format;

    // Override method
    @Override
    public Manageable read(Scanner scanner) {
        super.read(scanner);
        url = scanner.next();
        format = scanner.next();
        return this;
    }

    @Override
    public void printBookType() {
        System.out.print("[전자책] ");
    }

    @Override
    public void print() {
        super.print();
        System.out.printf("\t\t %s [%s]\n", url, format);
    }

    @Override
    public boolean matches(String kwd) {
        super.matches(kwd);
        return url.equals(kwd) || format.equals(kwd);
    }
}
