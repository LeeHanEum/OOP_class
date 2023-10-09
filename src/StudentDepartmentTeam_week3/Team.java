package StudentDepartmentTeam_week3;

import java.util.ArrayList;
import java.util.Scanner;

public class Team {

    String teamName;
    ArrayList<Student> members = new ArrayList<>();

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public void read(Scanner scanner, Department department){
        int studentNumber = 0;
        Student st = null;
        while(true){
            studentNumber = scanner.nextInt();
            if(studentNumber == 0){
                break;
            }
            st = department.findStudent(studentNumber);
            members.add(st);
            st.setTeam(this);
        }
    }


    void print(){
        System.out.printf("%s : ", teamName);
        for(Student st : members){
            System.out.printf("%s ", st.name);
        }
        System.out.println();
    }
}
