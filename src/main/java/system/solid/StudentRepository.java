package system.solid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentRepository{ // TODO:  Dependency Inversion Principle
    private final List<Student> students;

    public StudentRepository(List<Student> students){
        this.students = students;
    }

    public void add(Student student){
        this.students.add(student);
    }

    public List<Student> findStudent(){
        return students;
    }
}

////❌ BAD (Concrete dependency)
//public class StudentRepository {
//    private ArrayList<Student> students = new ArrayList<>();
//    private void add(Student s){
//        students.add(s);
//    }
//}
