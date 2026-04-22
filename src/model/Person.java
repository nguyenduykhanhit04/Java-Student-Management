package model;

/**
 * Đây là class cha, không dùng để tạo object trực tiếp.
 */
public abstract class Person {
    /**
     * Đây là encapsulation.
     * Không cho class khác đụng trực tiếp vào dữ liệu.
     */
    private String id;
    private String name;
    private int age;

    /**
     * Constructor
     * Dùng để khởi tạo object ngay khi tạo mới.
     */
    public Person(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
    /**
     * Abstract method
     * Nghĩa là class con bắt buộc phải viết lại hàm này.
     */
    public abstract void displayInfo();
}
