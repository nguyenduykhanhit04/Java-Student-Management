import model.Student;
import service.StudentManager;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();

        manager.addStudent(new Student( "S001", "Khanh", 21, 3.46));
        manager.addStudent(new Student( "S002", "Duy", 22, 3.76));
        manager.addStudent(new Student( "S003", "Khanh2", 22, 3.56));
        manager.addStudent(new Student( "S004", "Khanh3", 23, 3.76));
        manager.addStudent(new Student( "S005", "Khanh4", 24, 3.86));

        System.out.println("Danh sach ban dau");
        manager.displayAllStudents();

        // Update
        System.out.println("Update SOO1");
        boolean updated = manager.updateStudent("S001", new Student("S001", "Khanh updated", 21, 3.8));
        System.out.println(updated ? "Update thanh cong" : "Update that bai");

        manager.displayAllStudents();

        // Delete
        System.out.println("Delete S002");
        boolean deleted = manager.deleteStudent("S002");
        System.out.println(deleted ? "Delete thanh cong" : "Delete that bai");
        manager.displayAllStudents();

        System.out.println("Tìm S001");
        Student student = manager.findStudentById("S001");
        if (student != null) {
            System.out.println("----------------");
            System.out.println("Thong tin cua student: ");
            student.displayInfo();
        } else {
            System.out.println("Khong tim thay sinh vien");
        }

        System.out.println("=== Sinh vien xuat xac ===");
        manager.getExcellentStudents();

        System.out.println("=== Sap xep GPA giam dan ===");
        manager.sortByGpaDesc();

        System.out.println("=== Top 2 ===");
        manager.top2Students();

        System.out.println("=== Tim bang Stream ===");
        Student s = manager.findByIdStream("S001");
        if (s != null) s.displayInfo();
    }
}