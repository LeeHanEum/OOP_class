package Manager_store.impl.department;

import java.util.Scanner;

import Manager_store.manager.Factory;
import Manager_store.manager.Manageable;
import Manager_store.manager.Manager;

public class Department {
    Scanner scan = new Scanner(System.in);

    static Manager studentMgr = new Manager();
    static Manager lectureMgr = new Manager();

    void run() {
        lectureMgr.readAll("src/Manager_store/department/input/lecture.txt", Lecture::new);
//        lectureMgr.printAll();
//        studentMgr.readAll("src/Manager_store/department/input/student.txt", Student::new);
//        studentMgr.printAll();
        searchMenu();
    }
    void searchMenu()	{
    }

    public static void main(String args[]) {
        Department my = new Department();
        my.run();
    }
}