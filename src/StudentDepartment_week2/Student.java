package StudentDepartment_week2;

import javax.print.attribute.standard.PrinterMakeAndModel;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Character.isDigit;

public class Student {

    Random rand = new Random();

    String name;
    public int id;
    String phone;
    int year;

    int score;

    public Student() {
    }

    void read(Scanner scanner, int id) {
        this.id = id;
        name = scanner.next();
        phone = scanner.next();
        year = scanner.nextInt();
    }

    void print() {
        System.out.format("학번: %d, 이름: %s, 전화번호: %s, 학년: %d\n", id, name, phone, year);
    }

    boolean matches(int begin, int end) {
        System.out.println(begin + " " + end);
        return begin <= score && score <= end;
    }

    boolean matches(String name, int id, String phone, int year) {
        return this.name.equals(name) || this.id == id || this.phone.equals(phone) || this.year == year;
    }

    boolean matches(String kwd) {
        if(kwd.length() == 1 && isDigit(kwd.charAt(0))){
            return name.equals(kwd) || phone.equals(kwd) || (""+id).equals(kwd) || (""+year).equals(kwd);
        }
        return name.contains(kwd) || phone.contains(kwd) || (""+id).contains(kwd) || (""+year).contains(kwd);
    }

    boolean matches(String[] kwds){
        for(String kwd : kwds){
            if(kwd == null || kwd.isEmpty()){
                return false;
            }
            if(kwd.charAt(0) == '-' && !matches(kwd.substring(1))){
                continue;
            }
            if(!matches(kwd)){
                return false;
            }
        }
        return true;
    }

    void inputScore(){
//        System.out.printf("%s", name);
//        score = scanner.nextInt();
        score = rand.nextInt(100)+1;
        System.out.printf("%s : %d점\n", name, score);
    }

    void readScores(){

    }

    void searchScores(){

    }

}
