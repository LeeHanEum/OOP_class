package Homework_store;

import java.util.Scanner;

public interface Manageable {

    void read(Scanner scan);

    boolean matches(String kwd);

    void print();



}
