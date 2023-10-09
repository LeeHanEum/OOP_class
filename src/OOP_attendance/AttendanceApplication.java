package OOP_attendance;

import OOP_attendance.Controller.AttendanceController;

public class AttendanceApplication {
    public static void main(String[] args) {
        System.out.println("교수용 출석체크 프로그램");
        AttendanceController attendanceController = AttendanceController.getInstance();
        attendanceController.run();
    }
}
