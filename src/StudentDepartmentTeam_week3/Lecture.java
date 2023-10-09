package StudentDepartmentTeam_week3;

import java.util.Scanner;

public class Lecture {

    private String code;
    private String lectureName;
    private int year;
    private String day;
    private String time;

    public Lecture(String code) {
        this.code = code;
    }

    public Lecture read(Scanner scanner, Department department){
        lectureName = scanner.next();
        year = scanner.nextInt();
        day = scanner.next();
        time = scanner.next();
        return this;
    }

    public void print(){
        System.out.printf("%s %s %d %s %s\n", code, lectureName, year, day, time);
    }

    public boolean matches(String kwd){
        return false;
    }

    public String getCode() {
        return code;
    }
}
