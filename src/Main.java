import model.Student;
import service.StudentManager;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();

        manager.addStudent(new Student( "S001", "Khanh", 21, 3.46));
        manager.addStudent(new Student( "S002", "Duy", 22, 3.76));
        manager.addStudent(new Student( "S003", "Khanh2", 22, 3.56));
        manager.addStudent(new Student( "S004", "Khanh3", 23, 3.76));
        manager.addStudent(new Student( "S005", "Khanh4", 24, 3.86));

        System.out.println("Tìm S001");
        Optional<Student> studentOpt = manager.findByIdOptional("S001");

        if (studentOpt.isPresent()) {
            studentOpt.get().displayInfo();
        } else {
            System.out.println("Khong tim thay");
        }
        System.out.println("Cách xịn hơn");
        manager.findByIdOptional("S001")
                .ifPresent(Student::displayInfo);


    }
}