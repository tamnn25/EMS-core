package system.solid;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) { // TODO: Dependency injection
        List<Student> students = new ArrayList<>();
        StudentRepository repo = new StudentRepository(students);
        StudentService service = new StudentService(repo);

        service.add(new Student("Charlie", 85));
        service.add(new Student("Alice", 90));
        service.add(new Student("Bob", 80));

        Comparator<Student> comparator = new StudentNameComparator();

        System.out.println("comparator" + comparator);

        students.sort(comparator);

        students.forEach(s -> System.out.println(s.getName() + "---" + s.getScore()));


    }
}
