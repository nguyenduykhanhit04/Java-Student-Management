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

    public boolean addStudent(Student student) {
        for (Student s : students) {
            if (s.getId().equalsIgnoreCase(student.getId())) {
                System.out.println("ID is exists");
                return false;
            }
        }
        students.add(student);
        return true;
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

    /**
     * duyệt list
     * tìm đúng id
     * dùng .set() để thay thế object
     */
    public boolean updateStudent(String id, Student newStudent) {
        for (int i = 0; i < students.size(); i++ ) {
            if(students.get(i).getId().equalsIgnoreCase(id)) {
                students.set(i, newStudent);
                return true;
            }
        }
        return false;
    }

    /**
     * duyệt list
     * tìm đúng id
     * dùng .remove() để xóa object
     */
    public boolean deleteStudent(String id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equalsIgnoreCase(id)) {
                students.remove(i);
                return true;
            }
        }
        return false;
    }
}
