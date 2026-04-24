package model;

import java.sql.SQLOutput;

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

    public Student(String id, String name, int age, double gpa) {
        /**
         * Dùng để gọi constructor của class cha.
         * Vì id, name, age nằm ở Person, nên phải gọi super.
         * Phải gọi super trước
         */
        super(id, name, age);
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getRank() {
        if (gpa > 3.6) return "Xuất xắc";
        else if (gpa > 3.2) return "Giỏi";
        else if (gpa > 2.8) return "Khá";
        else return "Trung bình";
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
        System.out.println("Rank: " + getRank());
    }

}

