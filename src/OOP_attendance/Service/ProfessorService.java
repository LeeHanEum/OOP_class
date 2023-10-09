package OOP_attendance.Service;

import OOP_attendance.Entity.Professor;
import OOP_attendance.Entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProfessorService {

    private static long sequence = 0L;

    private static long studentSequence = 0L;

    private static ProfessorService instance;

    public static ProfessorService getInstance() {
        if (instance == null) {
            instance = new ProfessorService();
        }
        return instance;
    }

    public List<Student> registerStudent(Scanner scanner, Professor professor){
        List<Student> students = new ArrayList<>();

        System.out.println("학생 이름을 입력하세요.");
        while (true){
            String name = scanner.nextLine();
            if(name.equals("0")){
                break;
            }
            students.add(new Student(studentSequence++, name, professor));
        }
        return students;
    }

    private String attendanceCount(Student student){
        int count = 0;
        for(Boolean attendance : student.getAttendance()){
            if(attendance){
                count++;
            }
        }
        return count + "/" + student.getAttendance().size();
    }

    public void print(List<Student> students){
        for(Student student : students){
            if(student.getId()==0) continue;
            System.out.println("아이디:" + student.getId() + "\t이름:" + student.getName() + "\t담당교수:" + student.getProfessor().getName() + "\t출석횟수:" + attendanceCount(student));
        }
    }

    public void registerAttendance(Scanner scanner, List<Student> students){
        print(students);
        System.out.print("출석을 등록할 학생의 아이디를 입력하세요 : ");
        Long id = scanner.nextLong();
        Student student = Student.getInstance().findById(students, id);

        System.out.println(student.getName() + " 학생 출석부");
        int i;
        for (i = 1; i < student.getAttendance().size(); i++) {
            System.out.println((i+1) + "주차 출석 여부 : " + student.getAttendance().get(i));
        }
        System.out.print(i+1 + "주차 출석 여부(출석:true, 결석:false) : ");
        Boolean attendance = scanner.nextBoolean();
        student.getAttendance().add(attendance);
    }

    public Professor login(Scanner scanner) {

        System.out.println("교수자 로그인");
        System.out.print("이름을 입력하세요 : ");
        String name = scanner.next();

        return new Professor(++sequence, name);
    }
}
