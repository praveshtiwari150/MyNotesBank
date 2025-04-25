import java.util.*;

public class Main {

    public static class Person {
        int age;
        String name;

        void saysHi() {
            System.out.println(name + "[" + age + "]" + " says " + "hi");
        }
    }
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.age = 26;
        p1.name = "Pravesh";

        p1.saysHi();

        Person p3 = p1;
        p3.age = 30;
        p3.saysHi();
        p1.saysHi();
    }
}