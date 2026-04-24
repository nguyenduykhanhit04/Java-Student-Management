package service;

import model.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import exception.StudentNotFoundException;

public class StudentManager {
    /**
     * private List<Student> students;
     * Đây là nơi lưu toàn bộ sinh viên.
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

    public Optional<Student> findByIdOptional(String id) {
        return students.stream()
                .filter(s -> s.getId().equalsIgnoreCase(id))
                .findFirst();
    }

    public Student findOrThrow(String id) throws StudentNotFoundException {
        return findByIdOptional(id)
                .orElseThrow(() -> new StudentNotFoundException("Khong tim thay ID: " + id));
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

    public void updateOrThrow(String id, Student newStudent) throws StudentNotFoundException {
        Student old = findOrThrow(id);
        students.set(students.indexOf(old), newStudent);
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

    public void deleteOrThrow(String id) throws StudentNotFoundException {
        Student student = findOrThrow(id);
        students.remove(student);
    }

    public void getExcellentStudents() {
        students.stream()
                .filter(s -> s.getGpa() >= 3.6)
                .forEach(Student::displayInfo);
    }

    public Student findByIdStream(String id) {
        return students.stream().filter(s -> s.getId().equalsIgnoreCase(id)).findFirst().orElse(null);
    }

    public void sortByGpaDesc() {
        students.stream()
                .sorted((s1, s2) -> Double.compare(s2.getGpa(), s1.getGpa()))
                .forEach(Student::displayInfo);
    }

    public void top2Students() {
        students.stream()
                .sorted((s1, s2) -> Double.compare(s2.getGpa(), s1.getGpa()))
                .limit(2)
                .forEach(Student::displayInfo);
    }
}
