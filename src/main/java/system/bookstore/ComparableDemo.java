package system.bookstore;

import system.bookstore.Book;
import system.bookstore.Student;
import java.util.*;

public class ComparableDemo {
    public static void main(String[] args) {
        System.out.println("=== DEMO COMPARABLE INTERFACE ===\n");

        List<Student> listStudents = List.of(
                new Student("01", "stu01", 5, 1),
                new Student("01", "stu02", 5, 1)
        );

        Student min = GenericSorter.findMin(listStudents);

        System.out.println(min);

        // Demo với Book
//        demoBookComparable();

//        System.out.println("\n" + "=".repeat(50) + "\n");

        // Demo với Student
//        demoStudentComparable();
    }

    private static void demoBookComparable() {
        System.out.println("📚 DEMO BOOK MODEL:");
        System.out.println("-".repeat(30));

        // Tạo danh sách sách
        List<Book> books = Arrays.asList(
                new Book("B003", "Java Programming", "John Doe", 45.99, 500),
                new Book("B001", "Python Basics", "Jane Smith", 29.99, 300),
                new Book("B002", "Data Structures", "Bob Wilson", 55.50, 450),
                new Book("B004", "Algorithms", "Alice Brown", 65.00, 600)
        );

        System.out.println("Danh sách sách ban đầu:");
        printBooks(books);

        // Sắp xếp theo title (sử dụng compareTo)
        System.out.println("\n1. Sắp xếp theo TÊN (A-Z):");
        List<Book> sortedByTitle = new ArrayList<>(books);
//        Collections.sort(sortedByTitle);  // Sử dụng compareTo() trong Book
        printBooks(sortedByTitle);

        // Sắp xếp theo giá
        System.out.println("\n2. Sắp xếp theo GIÁ (tăng dần):");
        List<Book> sortedByPrice = new ArrayList<>(books);
        sortedByPrice.sort(Book::compareByPrice);
        printBooks(sortedByPrice);

        // Sắp xếp theo số trang
        System.out.println("\n3. Sắp xếp theo SỐ TRANG (giảm dần):");
        List<Book> sortedByPages = new ArrayList<>(books);
        sortedByPages.sort((b1, b2) -> b2.compareByPages(b1));  // Lambda để đảo ngược
        printBooks(sortedByPages);
    }

    private static void demoStudentComparable() {
        System.out.println("🎓 DEMO STUDENT MODEL:");
        System.out.println("-".repeat(30));

        // Tạo danh sách sinh viên
        List<Student> students = Arrays.asList(
                new Student("S003", "Nguyen Van A", 20, 3.2),
                new Student("S001", "Tran Thi B", 22, 3.8),
                new Student("S004", "Le Van C", 19, 3.5),
                new Student("S002", "Pham Thi D", 21, 3.9)
        );

        System.out.println("Danh sách sinh viên ban đầu:");
        printStudents(students);

        // Sắp xếp theo tên (natural order)
        System.out.println("\n1. Sắp xếp theo TÊN (A-Z):");
        List<Student> sortedByName = new ArrayList<>(students);
//        Collections.sort(sortedByName);  // Sử dụng compareTo() trong Student
        printStudents(sortedByName);

        // Sắp xếp theo GPA (cao xuống thấp)
        System.out.println("\n2. Sắp xếp theo GPA (cao nhất trước):");
        List<Student> sortedByGpa = new ArrayList<>(students);
        sortedByGpa.sort(Student::compareByGpa);
        printStudents(sortedByGpa);

        // Sắp xếp theo tuổi
        System.out.println("\n3. Sắp xếp theo TUỔI (trẻ nhất trước):");
        List<Student> sortedByAge = new ArrayList<>(students);
        sortedByAge.sort(Student::compareByAge);
        printStudents(sortedByAge);

        // So sánh trực tiếp
        System.out.println("\n4. So sánh trực tiếp giữa 2 sinh viên:");
        Student s1 = students.get(0);
        Student s2 = students.get(1);

        int result = s1.compareTo(s2);
        System.out.println("So sánh " + s1.getName() + " với " + s2.getName() + ":");
        if (result < 0) {
            System.out.println("  → " + s1.getName() + " đứng TRƯỚC " + s2.getName());
        } else if (result > 0) {
            System.out.println("  → " + s1.getName() + " đứng SAU " + s2.getName());
        } else {
            System.out.println("  → Hai sinh viên BẰNG NHAU về tên");
        }
    }

    private static void printBooks(List<Book> books) {
        System.out.println("ID     Title                 Author         Price   Pages");
        System.out.println("----------------------------------------------------------");
        for (Book book : books) {
            System.out.printf("%-6s %-20s %-13s %7.2f %6d\n",
                    book.getId(),
                    book.getTitle(),
                    book.getAuthor(),
                    book.getPrice(),
                    book.getPages());
        }
    }

    private static void printStudents(List<Student> students) {
        System.out.println("ID     Name            Age   GPA");
        System.out.println("---------------------------------");
        for (Student student : students) {
            System.out.printf("%-6s %-15s %3d   %.2f\n",
                    student.getStudentId(),
                    student.getName(),
                    student.getAge(),
                    student.getGpa());
        }
    }
}