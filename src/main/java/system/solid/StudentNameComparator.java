package system.solid;

import java.util.Comparator;

public class StudentNameComparator implements Comparator<Student> { // TODO: open close principle

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

//public class StudentSorter {
//    public void sortByName(List<Student> students) {
//        // name sort logic
//    }
//
//    public void sortByScore(List<Student> students) {
//        // score sort logic
//    }
//}

