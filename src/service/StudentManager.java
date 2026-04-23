package service;

import model.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    /**
     * private List<Student> students;
     *
     * Đây là nơi lưu toàn bộ sinh viên.
     *
     * List là interface
     * ArrayList là class triển khai phổ biến nhất
     */
    private List<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("Danh sach sinh vien dang rong");
            return;
        }

        for (Student student : students) {
            student.displayInfo();
            System.out.println("-------");
        }
    }

    public Student findStudentById(String id) {
        for (Student student : students) {
            if (student.getId().equalsIgnoreCase(id)) {
                return student;
            }
        }
        return null;
    }
}
