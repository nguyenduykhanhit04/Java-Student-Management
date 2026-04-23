import model.Student;
import service.StudentManager;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();

        Student student1 = new Student(3.46, "S001", "Khanh", 21);
        Student student2 = new Student(3.76, "S002", "Duy", 22);

        manager.addStudent(student1);
        manager.addStudent(student2);

        System.out.println("=== DANH SACH SINH VIEN ===");
        manager.displayAllStudents();

        System.out.println("=== TIM SINH VIEN THEO ID ===");
        Student foundStudent = manager.findStudentById("S002");

        if (foundStudent != null) {
            foundStudent.displayInfo();
        } else {
            System.out.println("Khong tim thay sinh vien.");
        }
    }
}