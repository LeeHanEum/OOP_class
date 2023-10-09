package wnsdud_week4;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Lecture {
    String code;
    String name;
    int year;
    String day;
    String time;

    public Lecture() {

    }
    public Lecture(String code) {
        this.code = code;
    }

    public void read(Scanner scan) {
            code = scan.next();
            name = scan.next();
            year = scan.nextInt();
            day = scan.next();
            time = scan.next();
    }

    void print() {
        System.out.format("[%s] %s (%d학년) %s/%s\n",
                code,name,year,day,time);
    }

    public boolean matches(String code2) {
        if (code.equals(code2))
            return true;
        return false;
    }
}
