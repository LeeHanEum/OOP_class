package OOP_attendance.Entity;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private Long id;

    private String name;

    private List<Boolean> attendance = new ArrayList<>();

    private Professor professor;

    private static Student instance;

    public static Student getInstance() {
        if (instance == null) {
            instance = new Student();
        }
        return instance;
    }

    public Student findById(List<Student> students, Long id){
        for(Student student : students){
            if(student.getId().equals(id)){
                return student;
            }
        }
        return null;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Boolean> getAttendance() {
        return attendance;
    }

    public Professor getProfessor() {
        return professor;
    }

    public Student() {
    }

    public Student(Long id, String name, Professor professor) {
        this.id = id;
        this.name = name;
        this.professor = professor;
    }
}
