package wnsdud_week4;

import java.util.Scanner;

public class ELecture extends Lecture{

    String url;

    public ELecture(String code) {
        this.code = code;
    }
    public ELecture() {

    }

    @Override
    public void read(Scanner scan) {
        super.read(scan);
        url = scan.next();
    }

    @Override
    void print() {
        super.print();
        System.out.printf("\t\t[플립러닝] %s\n", url);
    }

    @Override
    public boolean matches(String code2) {
        if (super.matches(code2))
            return true;
        return code.contains(code2);
    }

}
