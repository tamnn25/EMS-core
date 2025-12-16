package system.bookstore;

import system.bookstore.MyComparable;

public class Student implements MyComparable<Student> {
    // Fields
    private String studentId;
    private String name;
    private int age;
    private double gpa;

    // Constructor
    public Student(String studentId, String name, int age, double gpa) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    // Getters and Setters
    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public double getGpa() { return gpa; }
    public void setGpa(double gpa) { this.gpa = gpa; }

    // Implement MyComparable interface
    @Override
    public int compareTo(Student other) {
        // Natural ordering: So sánh theo tên
        return this.name.compareTo(other.name);
    }

    // Alternative comparisons
    public int compareByGpa(Student other) {
        // GPA cao hơn đứng trước
        return Double.compare(other.gpa, this.gpa);  // Đảo ngược để GPA cao trước
    }

    public int compareByAge(Student other) {
        // Tuổi nhỏ hơn đứng trước
        return Integer.compare(this.age, other.age);
    }

    public int compareById(Student other) {
        // So sánh theo ID
        return this.studentId.compareTo(other.studentId);
    }

    @Override
    public String toString() {
        return String.format("Student[ID=%s, Name='%s', Age=%d, GPA=%.2f]",
                studentId, name, age, gpa);
    }
}
