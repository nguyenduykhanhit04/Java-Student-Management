import model.Student;
import service.StudentManager;
import java.util.Optional;
import exception.StudentNotFoundException;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();

        manager.addStudent(new Student("S001", "Khanh", 21, 3.46));
        manager.addStudent(new Student("S002", "Duy", 22, 3.76));
        manager.addStudent(new Student("S003", "Khanh2", 22, 3.56));

        // 🔥 Optional (bạn đang dùng)
        System.out.println("=== Optional ===");
        manager.findByIdOptional("S001")
                .ifPresentOrElse(
                        Student::displayInfo,
                        () -> System.out.println("Khong tim thay")
                );

        // 🔥 Exception (thêm mới)
        System.out.println("=== Exception ===");
        try {
            Student s = manager.findOrThrow("S001");
            s.displayInfo();
        } catch (StudentNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // 🔥 Test lỗi
        System.out.println("=== Test Exception (S999) ===");
        try {
            Student s = manager.findOrThrow("S999");
            s.displayInfo();
        } catch (StudentNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}