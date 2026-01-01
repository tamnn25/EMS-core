package system.solid;

public class CoreJava {
    public static void main(String[] args) {
        String s1 = new String("Hello");
        String s2 = new String("Hello");

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

        int a = 10;          // primitive
        Integer b = a;       // autoboxing happens here

        System.out.println(b); // 10
        System.out.println(b.getClass().getName());

        System.out.println(a);
    }
}
