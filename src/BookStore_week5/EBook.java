package BookStore_week5;

import java.util.Scanner;

public class EBook extends Book{

    // member variables
    String url;
    String format;

    // Override method
    @Override
    protected Book read(Scanner scanner) {
        super.read(scanner);
        url = scanner.next();
        format = scanner.next();
        return this;
    }

    @Override
    protected void printBookType() {
        System.out.print("[전자책] ");
    }

    @Override
    protected void print() {
        super.print();
        System.out.printf("\t\t %s [%s]\n", url, format);
    }

    @Override
    protected boolean matches(String kwd) {
        super.matches(kwd);
        return url.equals(kwd) || format.equals(kwd);
    }
}
