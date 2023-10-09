package ExtendsLecture;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Department {

    Scanner scanner = new Scanner(System.in);

    List<Student> studentList = new ArrayList<>();
    List<Lecture> lectureList = new ArrayList<>();

    // main
    public static void main(String[] args) {
        System.out.println("학과 학생 수강 신청 관리 프로그램");
        new Department().run();
    }

    // run menu
    public void run(){
        int menu;
        readAllLectures();
        readAllStudents();

        while(true){
            System.out.println("\n\n메뉴를 선택하세요.");
            System.out.println("(1) 강의 목록 조회\n(2) 학생 목록 조회\n(3) 연관 검색\n(0) 종료");
            menu = scanner.nextInt();
            switch (menu) {
                case 1: printAllLectures(); break;
                case 2: printAllStudents(); break;
                case 3: searchMenu(); break;
                case 0 : return;
                default: System.out.println("잘못된 입력입니다.");
            }
        }
    }
    private void searchMenu(){
        int menu;
        while(true){
            System.out.println("\n(1) 과목별 수강생 검색\n(2) 요일별 수강생 검색\n(3) 타학년 과목 수강생 조회\n(0) 종료");
            menu = scanner.nextInt();
            switch (menu) {
                case 1: searchStudentsByLecture(); break;
                case 2: searchStudentsByDay(); break;
                case 3: searchStudentsDiffGrades(); break;
                case 0 : return;
                default: System.out.println("잘못된 입력입니다.");
            }
        }
    }

    // read methods
    private void readAllLectures(){
        Lecture lecture = null;
        System.out.println("\n강좌 정보를 입력하세요. (종료: 0)");
        while(true){
            int n = scanner.nextInt();
            switch (n){
                case 1 : lecture = new Lecture(); break;
                case 2 : lecture = new ELecture(); break;
                case 0 : return;
                default: break;
            }
            assert lecture != null;
            lectureList.add(lecture.read(scanner));
        }
    }
    private void readAllStudents(){
        int id;
        System.out.println("\n학생 정보를 입력하세요. (종료: 0)");
        while(true){
            id = scanner.nextInt();
            if(id == 0) break;
            if(findStudent(id) != null){
                System.out.println("\n" + id + "는 이미 존재하는 학번입니다.");
                scanner.nextLine();
                continue;
            }
            studentList.add(new Student(id).read(scanner, this));
        }
    }

    // print methods
    private void printAllLectures(){
        System.out.println("\n강좌 정보");
        for(Lecture l : lectureList){
            l.print();
        }
    }
    private void printAllStudents(){
        System.out.println("\n학생 정보");
        for(Student s : studentList){
            s.printAndLecture();
        }
    }

    // search methods
    private void searchStudentsByLecture(){
        System.out.println("\n강좌 검색 키워드를 입력하세요. (강좌코드, 강좌명, 학년, 요일, 시간, URL)");
        String kwd = scanner.next();
        Lecture lecture = null;
        for (Lecture l : lectureList){
            if(l.matches(kwd)){
                System.out.println();
                lecture = l;
                l.print();
                for (Student s : studentList){
                    s.containsLecture(l);
                }
            }
        }
        if(lecture == null){
            System.out.println("검색 결과가 없습니다.");
        }
    }
    private void searchStudentsByDay(){
        System.out.println("\n요일을 입력하세요. (월, 화, 수, 목, 금)");
        String day = scanner.next();
        System.out.print("\n" + day + "요일에 수강하는 학생 목록 : ");
        for (Student s : studentList){
            s.containsDay(day);
        }
    }
    private void searchStudentsDiffGrades(){
        int cnt;
        System.out.println("\n\n타 학년 과목을 듣는 학생 수를 검색합니다.");
        for(Lecture l : lectureList){
            cnt = 0;
            for(Student s : studentList){
                if(s.isMatchYear(l)) cnt++;
            }
            if(cnt == 0) continue;
            l.print(cnt);
        }
    }

    // find methods
    protected Lecture findLecture(String code){
        for(Lecture l : lectureList){
            if(l.getCode().equals(code)) return l;
        }
        return null;
    }
    protected Student findStudent(int id){
        for(Student s : studentList){
            if(s.getId() == id) return s;
        }
        return null;
    }
}
