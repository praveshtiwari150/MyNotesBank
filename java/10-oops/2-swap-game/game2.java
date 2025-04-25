import java.util.*;

class game2 {

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

        Person p2 = new Person();
        p2.age = 20;
        p2.name = "Raghu";
        p1.saysHi();
        p2.saysHi();

        swap2(p1, p2);
        p1.saysHi();
        p2.saysHi();
    }

    public static void swap2(Person p1, Person p2) {
        int age = p1.age;
        p1.age = p2.age;
        p2.age = age;

        String name = p1.name;
        p1.name = p2.name;
        p2.name = name;
    }
}