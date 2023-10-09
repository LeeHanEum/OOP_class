package StudentDepartment_week2;

import java.util.ArrayList;
import java.util.Scanner;

public class Department {

    Scanner scanner = new Scanner(System.in);
    ArrayList<Student> studentArrayList = new ArrayList<>();

    // 보고서 낼때 스샷, 클래스 다이어 그램 포함


    void run(){
        int menu;
        readAll();
        while(true){
            System.out.println("(1) 전체 출력 \n(2) 점수 입력 \n(3) 검색 \n(4) 멀티키워드 \n(5) 점수 검색 \n(0) 종료");
            menu = scanner.nextInt();
            switch (menu){
                case 1 : printAll(); break;
                case 2 : inputScores(); break;
                case 3 : search(); break;
                case 4 : searchMulti(); break;
                case 5 : searchScores(); break;
                case 0 : return;
                default: System.out.println("잘못된 입력입니다.");
            }
        }
    }

    void printAll() {
        for (Student s : studentArrayList) {
            s.print();
            System.out.println();
        }
    }

    void readAll() {
        int id;
        Student student = null;
        while(true) {
            id = scanner.nextInt();
            if (id == 0) {
                break;
            }
            student = new Student();
            student.read(scanner, id);
            studentArrayList.add(student);
        }
    }


    void search() {
        String name = null;
        int id;
        String phone;
        int year;

        while(true) {
            System.out.print("이름 : ");
            name = scanner.next();
            if (name.equals("end")) {
                break;
            }
            System.out.print("학번 : ");
            id = scanner.nextInt();
            System.out.print("전화번호 : ");
            phone = scanner.nextLine();
            scanner.next();
            System.out.print("학년 : ");
            year = scanner.nextInt();

            for(Student s : studentArrayList){
                if(s.matches(name, id, phone, year)) {
                    s.print();
                }
            }
            System.out.println();
        }
    }

    void searchScores() {
        String scoreBegin = null;
        String scoreEnd = null;
        while(true) {
            System.out.print("검색할 점수 구간");
            scoreBegin = scanner.next();
            scoreEnd = scanner.next();

            if (scoreBegin.equals("end")) {
                break;
            }
            if (scoreBegin.equals("-")) {
                scoreBegin = "0";
            }
            if (scoreEnd.equals("-")) {
                scoreEnd = "101";
            }


            for (Student s : studentArrayList) {
                if (s.matches(Integer.parseInt(scoreBegin), Integer.parseInt(scoreEnd))) {
                    s.print();
                }
            }
        }
    }
    void searchMulti() {
        String line = null;
        String[] kwdArr;

        while(true){
            System.out.print("검색 키워드 여러개(빈칸으로 구분) : ");
            if(line == null) {
                scanner.nextLine();
            }
            line = scanner.nextLine();
            if (line.equals("end")) {
                break;
            }
            kwdArr = line.split(" ");

            for(Student s : studentArrayList){
                if(s.matches(kwdArr)) {
                    s.print();
                }
            }
        }
    }

    void inputScores(){
        System.out.print("학생 점수 입력 : ");
        for(Student s : studentArrayList){
            s.inputScore();
        }

    }

    public static void main(String[] args) {
        Department department = new Department();
        department.run();
    }
}
