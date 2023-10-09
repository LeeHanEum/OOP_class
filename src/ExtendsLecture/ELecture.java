package ExtendsLecture;

import java.util.Scanner;

public class ELecture extends Lecture{

    // member variables
    private String url;

    // constructor
    public ELecture() {
    }

    // Override methods
    @Override
    protected Lecture read(Scanner scanner) {
        super.read(scanner);
        url = scanner.next();
        return this;
    }
    @Override
    protected void print() {
        super.print();
        System.out.println("\t\t" + url);
    }
    @Override
    protected boolean matches(String kwd) {
        if(super.matches(kwd)) return true;
        return url.contains(kwd);
    }

}
