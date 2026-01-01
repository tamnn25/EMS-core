package system.solid;

//correct for Single responsibility
public class Student { //TODO: Single responsibility
    private final String name;
    private final int score;

    public Student(String name, int score){
        this.name = name;
        this.score = score;
    }

    public String getName(){return this.name;}
    public int getScore() {return this.score;}
}
//
//public class StudentBadForS {
//    private String name;
//    private int score;
//
//    public void print() {
//        System.out.println(name + " - " + score);
//    }
//
//}
