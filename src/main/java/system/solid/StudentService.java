package system.solid;

import java.util.List;

public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public void add(Student student) {
        this.studentRepository.add(student);
    }

    public List<Student> getAll() {
        return studentRepository.findStudent();
    }
}


//public class StudentService {
//    StudentRepository repo = new StudentRepository(new ArrayList<>());
//
//    public void addStudent(Student s) { repo.add(s); }
//
//    public void printStudents() { /* printing */ }
//
//    public void sortByName() { /* sorting */ }
//}
