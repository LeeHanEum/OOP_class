package ExtendsLecture;

import java.util.Scanner;

public class Lecture {

    // member variables
    String code;
    String lectureName;
    int year;
    String day;
    String time;

    // getter
    public String getCode() {
        return code;
    }
    public int getYear() {
        return year;
    }

    // constructor
    public Lecture() {
    }

    // read & print methods
    protected Lecture read(Scanner scanner){
        code = scanner.next();
        lectureName = scanner.next();
        year = scanner.nextInt();
        day = scanner.next();
        time = scanner.next();
        return this;
    }
    protected void print(){
        System.out.printf("[%s] %s %d학년 %s%s\n", code, lectureName, year, day, time);
    }
    protected void print(int cnt){
        System.out.printf("[%s] %s %d학년 %s%s : %d명\n", code, lectureName, year, day, time, cnt);
    }

    // matches method
    protected boolean matches(String kwd){
        return this.code.equals(kwd) || this.lectureName.contains(kwd) || String.valueOf(this.year).equals(kwd) || this.day.equals(kwd) || this.time.equals(kwd);
    }

}
