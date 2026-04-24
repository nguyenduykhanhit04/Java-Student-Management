import model.Student;
import service.StudentManager;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();

        manager.addStudent(new Student("S001", "Khanh", 21, 3.46));
        manager.addStudent(new Student("S002", "Duy", 22, 3.76));
        manager.addStudent(new Student("S003", "Khanh2", 22, 3.56));
        manager.addStudent(new Student("S004", "Khanh3", 23, 3.76));
        manager.addStudent(new Student("S005", "Khanh4", 24, 3.86));

        System.out.println("=== Tim S001 ===");

        manager.findByIdOptional("S001")
                .ifPresentOrElse(
                        Student::displayInfo,
                        () -> System.out.println("Khong tim thay")
                );

        System.out.println("=== Tim S999 ===");

        manager.findByIdOptional("S999")
                .ifPresentOrElse(
                        Student::displayInfo,
                        () -> System.out.println("Khong tim thay")
                );
    }
}