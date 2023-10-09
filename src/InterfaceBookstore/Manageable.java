package InterfaceBookstore;

import java.util.Scanner;

public interface Manageable {

    // read method
    Manageable read(Scanner scanner);

    // print method
    void print();

    // search method
    boolean matches(String kwd);
}
