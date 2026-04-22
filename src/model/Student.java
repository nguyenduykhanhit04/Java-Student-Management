package model;

/**
 * Đây là kế thừa.
 *
 * Tức là Student sẽ có sẵn:
 * id
 * name
 * age
 * getter/setter
 * cấu trúc của Person
 */
public class Student extends Person {
    private double gpa;

    public Student(double gpa, String id, String name, int age) {
        this.gpa = gpa;
        /**
         * Dùng để gọi constructor của class cha.
         * Vì id, name, age nằm ở Person, nên phải gọi super.
         */
        super(id, name, age);
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    /**
     * Đây là annotation.
     * Nó báo rằng bạn đang ghi đè method từ class cha.
     */
    @Override
    public void displayInfo() {
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("GPA: " + gpa);
    }
}

