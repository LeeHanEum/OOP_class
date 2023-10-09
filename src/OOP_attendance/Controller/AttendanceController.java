package OOP_attendance.Controller;

import OOP_attendance.Entity.Professor;
import OOP_attendance.Entity.Student;
import OOP_attendance.Service.ProfessorService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AttendanceController {
    Scanner scanner = new Scanner(System.in);
    private Professor professor = Professor.getInstance();
    private List<Student> students = new ArrayList<>();
    private final ProfessorService professorService = ProfessorService.getInstance();

    private static AttendanceController instance;

    public static AttendanceController getInstance() {
        if (instance == null) {
            instance = new AttendanceController();
        }
        return instance;
    }

    public void run() {

        professor = professorService.login(scanner);
        System.out.println(professor.getName() + " 교수님 환영합니다.");

        if(professor.getId() == null){
            System.out.println("로그인 실패");
            return;
        }

        while(true){
            System.out.println("(1) 학생 등록\n(2) 출석부 조회\n(3) 출석부 등록\n(0) 로그아웃 및 종료");
            System.out.print("메뉴를 선택하세요 : ");
            int menu = scanner.nextInt();
            switch (menu) {
                case 1:
                    System.out.println("학생 등록");
                    students = professorService.registerStudent(scanner, professor);
                    break;
                case 2:
                    System.out.println("출석부 조회");
                    professorService.print(students);
                    break;
                case 3:
                    System.out.println("출석부 등록");
                    professorService.registerAttendance(scanner, students);
                    break;
                case 0:
                    System.out.println("로그아웃 및 종료");
                    return;
                default:
                    System.out.println("잘못된 입력입니다.");
                    break;
            }
            System.out.println();
        }

    }
}
