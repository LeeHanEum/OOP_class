package CourseApplication;

import CourseApplication.Department;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {

    // member variables
    private int id;
    private String name;
    private String phone;
    private int year;
    List<Lecture>  registeredList = new ArrayList<>();

    // getter
    public int getId() {
        return id;
    }
    public int getYear() {
        return year;
    }

    // constructor
    public Student(int id) {
        this.id = id;
    }

    // read & print methods
    protected Student read(Scanner scanner, Department department){
        name = scanner.next();
        phone = scanner.next();
        year = scanner.nextInt();

        String code;
        while(true){
            code = scanner.next();
            if(code.equals("0")) break;
            registeredList.add(department.findLecture(code));
        }
        return this;
    }
    protected void printAndLecture(){
        System.out.printf("학번: %d, 이름: %s, 전화번호: %s, 학년: %d\n", id, name, phone, year);
        for(Lecture l : registeredList){
            System.out.print("\t");
            l.print();
        }
    }
    protected void print(){
        System.out.printf("학번: %d, 이름: %s, 전화번호: %s, 학년: %d\n", id, name, phone, year);
    }

    // search method
    protected void containsLecture(Lecture lecture){
        if(registeredList.contains(lecture)){
            print();
        }
    }
    protected void containsDay(String day){
        for(Lecture l : registeredList){
            if(l.matches(day)){
                System.out.print(name + " ");
                break;
            }
        }
    }
    protected boolean isMatchYear(Lecture lecture){
        return year != lecture.getYear() && registeredList.contains(lecture);
    }

}
