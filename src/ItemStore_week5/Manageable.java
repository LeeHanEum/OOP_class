package ItemStore_week5;

import java.util.ArrayList;
import java.util.Scanner;

public interface Manageable {

    void read(Scanner scan);

    boolean matches(String kwd);

    void print();



}
