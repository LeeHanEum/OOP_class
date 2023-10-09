package CourseApplication;

import java.util.Scanner;

public class Lecture {

    // member variables
    private String code;
    private String lectureName;
    private int year;
    private String day;
    private String time;

    // getter
    public String getCode() {
        return code;
    }
    public int getYear() {
        return year;
    }

    // constructor
    public Lecture(String code) {
        this.code = code;
    }

    // read & print methods
    protected Lecture read(Scanner scanner){
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
